package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
	
	public static void main(String[] args) {
		SharedData sharedData = new SharedData();
	    ExecutorService executorService = Executors.newFixedThreadPool(3);
	
	    executorService.submit(() -> {
	        for (int i = 0; i < 5; i++) {
	        	sharedData.increment();
	            System.out.println("Thread 1 - Value: " + sharedData.getValue());
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	
	    executorService.submit(() -> {
	        for (int i = 0; i < 5; i++) {
	        	sharedData.decrement();
	            System.out.println("Thread 2 - Value: " + sharedData.getValue());
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	
	    executorService.submit(() -> {
	        for (int i = 0; i < 100; i++) {
	            System.out.println("Thread Read - Value: " + sharedData.getValue());
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    });
	    
	    executorService.shutdown();
	}
}


class SharedData {
    private int value;
    private final StampedLock lock = new StampedLock();

    public void setValue(int value) {
        long stamp = lock.writeLock();
        try {
            this.value = value;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public int getValue() {
        long stamp = lock.tryOptimisticRead();
        int val = this.value;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                val = this.value;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return val;
    }
    
    public void increment() {
    	setValue(++value);
    }
    
    public void decrement() {
    	setValue(--value);
    }
}
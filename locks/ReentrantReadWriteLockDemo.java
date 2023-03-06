package locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {
	
	private final List<String> list = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
    public static void main(String args[]) {
    	var demo = new ReentrantReadWriteLockDemo();
    	
    	final int numThreads = 5;
        final int numElements = 10;
        final ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < numElements; j++) {
                	demo.add(Thread.currentThread().getName() + " - Test " + j);
                }
            });
            
            executorService.execute(() -> {
                for (int j = 0; j < numElements; j++) {
                	System.out.println(demo.get(j));
                }
            });
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void add(String str) {
        lock.writeLock().lock();
        try {
        	System.out.println(lock);
        	System.out.println("Adding " + str);
            list.add(str);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String get(int index) {
    	lock.readLock().lock();
        try {
        	System.out.println("Getting at index " + index);
            return list.get(index);
        } finally {
            lock.readLock().unlock();
        }
    }

    public int size() {
        lock.readLock().lock();
        try {
            return list.size();
        } finally {
            lock.readLock().unlock();
        }
    }
    
}
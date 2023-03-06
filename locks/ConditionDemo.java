package locks;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	private static final int CAPACITY = 10;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition bufferNotFull = lock.newCondition(); 
	private final Condition bufferNotEmpty = lock.newCondition();

	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
    public void put() throws InterruptedException {
    	lock.tryLock(); 
    	try { 
    		while (count >= CAPACITY) { 
    			System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting"); 
    			bufferNotEmpty.await(); 
    		} 
    		
    		count++;
    		System.out.printf("\n%s added into queue", Thread.currentThread().getName());
    		bufferNotFull.signal();
    	} finally {
            lock.unlock();
        }
    }
    
    public void put2() throws InterruptedException {
    	lock.tryLock(); 
    	try { 
    		while (count >= CAPACITY) { 
    			System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting"); 
    			bufferNotEmpty.	awaitUninterruptibly(); 
    		} 
    		
    		count += 2;
    		System.out.printf("\n%s added into queue", Thread.currentThread().getName());
    		bufferNotFull.signal();
    	} finally {
            lock.unlock();
        }
    }

    public void get() throws InterruptedException {
    	lock.tryLock(1, TimeUnit.SECONDS); 
    	try { 
    		while (count <= 0) { 
    			System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting"); 
    			bufferNotFull.awaitUntil(new Date(System.currentTimeMillis() + 10000)); 
    		} 
    		
    		count--;
    		System.out.printf("\n%s removed from queue", Thread.currentThread().getName());
    		bufferNotEmpty.signal();
    	} finally {
            lock.unlock();
        }
    }
    
    public void get2() throws InterruptedException {
    	lock.tryLock(1, TimeUnit.SECONDS); 
    	try { 
    		while (count <= 0) { 
    			System.out.println(Thread.currentThread().getName() + " : Buffer is empty, waiting"); 
    			bufferNotFull.awaitNanos(100000); 
    		} 
    		
    		count -= 2;
    		System.out.printf("\n%s removed from queue", Thread.currentThread().getName());
    		bufferNotEmpty.signal();
    	} finally {
            lock.unlock();
        }
    }
    
    public void nothing() throws InterruptedException {
    	lock.tryLock(1, TimeUnit.SECONDS); 
    	try { 
    		while (count > 0 && count < CAPACITY) { 
    			System.out.println(Thread.currentThread().getName() + " : Nothing"); 
    			bufferNotFull.await(1, TimeUnit.SECONDS); 
    		} 
    	} finally {
            lock.unlock();
        }
    }
    
    public void getOrPut() throws InterruptedException {
    	lock.lockInterruptibly();
    	try {
    		if(count >= CAPACITY) {
    			count--;
        		System.out.printf("\n%s removed from queue", Thread.currentThread().getName());
        		bufferNotEmpty.signalAll();
    		}
    		
    		if(count <= 0) {
    			count++;
        		System.out.printf("\n%s added into queue", Thread.currentThread().getName());
        		bufferNotFull.signalAll();
    		}
    	} finally {
            lock.unlock();
        }
    }

    public static void main(String args[]) {
       final ConditionDemo counter = new ConditionDemo();
       
       Thread t1 = new Thread() {
           @Override
           public void run() {
        	   while(true) {
	        	   try {
	        		   counter.put();
	        		   Thread.sleep(2000);
	               } catch (InterruptedException ex) {
	                   ex.printStackTrace();                    
	               }
        	   }
           }
       };
     
       Thread t2 = new Thread() {
           @Override
           public void run() {
        	   while(true) {
	        	   try {
	        		   counter.get();
	        		   Thread.sleep(2000);
	               } catch (InterruptedException ex) {
	                   ex.printStackTrace();                    
	               }
        	   }
           }
       };
       
       Thread t3 = new Thread() {
           @Override
           public void run() {
        	   while(true) {
	        	   try {
	        		   counter.getOrPut();
	        		   Thread.sleep(2000);
	               } catch (InterruptedException ex) {
	                   ex.printStackTrace();                    
	               }
        	   }
           }
       };
       
       Thread t4 = new Thread() {
           @Override
           public void run() {
        	   while(true) {
	        	   try {
	        		   counter.put2();
	        		   Thread.sleep(2000);
	               } catch (InterruptedException ex) {
	                   ex.printStackTrace();                    
	               }
        	   }
           }
       };
       
       t1.start();
       t2.start();
       t3.start();
       t4.start();
   }

}
package basic;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadDemo implements Runnable {
	
	@Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
	
	public static void joinExample() {
		Thread t1 = new Thread(new ThreadDemo(), "t1");
        Thread t2 = new Thread(new ThreadDemo(), "t2");
        Thread t3 = new Thread(new ThreadDemo());
        
        t1.start();
        
        //start second thread after waiting for 2 seconds or if it's dead
        try {
            t1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t2.start();
        
        //start third thread only when first thread is dead or after waiting for 2 seconds and 500 nanoseconds
        try {
            t1.join(2000, 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t3.start();
        
        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All threads are dead, exiting main thread");
	}
	
	public static void interruptExemple() {
		GeneralInterrupt gi = new GeneralInterrupt();
	    
		Thread t1 = new Thread(gi);
	    t1.start();
	    
	    try {
	    	Thread.sleep(2000, 2000);
	    } catch (InterruptedException x) { }
			
	    System.out.println("in main() - interrupting other thread");
	   	t1.interrupt();
	   	
	    System.out.println("in main() - leaving");
	}
	
	public static void aliveExemple() {
		Thread thread = new MyThread();
	    thread.start();
	      
	    if (thread.isAlive()) {
	    	System.out.println("Thread has not finished");
	    } else {
	    	System.out.println("Finished");
	    }
	    
	    long delayMillis = 20; 
	    try {
			thread.join(delayMillis);

		    if (thread.isAlive()) {
		    	System.out.println("Thread has not finished");
			} else {
				System.out.println("Finished");
			}
	    } catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void priorityExameple() {
		new SimplePriorities(Thread.MAX_PRIORITY);
		new SimplePriorities(Thread.NORM_PRIORITY);
		new SimplePriorities(Thread.MIN_PRIORITY);
	}
	
	public static void nameIdStatusExample() {
		SimpleThread thrd = new SimpleThread();
	    thrd.setName("MyThread #1");
	    
	    showThreadStatus(thrd);
	    thrd.start();
	      
	    try {
			Thread.sleep(50);
		    showThreadStatus(thrd);
		    thrd.waiting = false;
		      
		    Thread.sleep(50); 
		    showThreadStatus(thrd);
		    thrd.notice();
		    
		    thrd.setName("New Name");
		    Thread.sleep(50);
		    showThreadStatus(thrd);
		    
		    int i = 0;
		    while(thrd.isAlive()) {
		    	if(i % 3000000 == 0) {
		    		System.out.println("alive");
		    	}
		    	i++;
		    }
		    showThreadStatus(thrd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	static void showThreadStatus(Thread thrd) {
		System.out.println(thrd.getName() + " Id:= " + thrd.getId() + " Alive:="+thrd.isAlive()+" State:=" + thrd.getState() );
	}
	
	public static void yieldExample() {
		Thread t1 = new Thread(new YieldThread(), "t1");
        Thread t2 = new Thread(new YieldThread(), "t2");
        Thread t3 = new Thread(new YieldThread());
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        
        t1.start();
        t2.start();
        t3.start();
	}
	
	public static void exceptionHandlerExample() {
		Thread t = new Thread(new AdminThread());
		
		Thread.UncaughtExceptionHandler duxh = Thread.getDefaultUncaughtExceptionHandler();
		System.out.println(duxh);
		
		Thread.UncaughtExceptionHandler uxh = new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + " throws exception: " + e);
			}
		};
		
		t.setUncaughtExceptionHandler(uxh);
		System.out.println(t.getUncaughtExceptionHandler().equals(duxh));
		
		Thread.setDefaultUncaughtExceptionHandler(uxh);
		duxh = Thread.getDefaultUncaughtExceptionHandler();
		System.out.println(t.getUncaughtExceptionHandler().equals(duxh));

		t.start();
	}
	
	public static void spinWaitExample() {
		final NormalTask task1 = new NormalTask();
	    final SpinWaitTask task2 = new SpinWaitTask();
	   
	    final Thread thread1 = new Thread(task1);
	    thread1.start();
	    
	    final Thread thread2 = new Thread(task2);
	    thread2.start();
	    
	    new Thread(() -> {
	    	try {
	    		Thread.sleep(3000);
	    	} catch (final InterruptedException e) {
	    		e.printStackTrace();
	    	} finally {
	    		task1.start();
	    		task2.start();
	    	}
	    }).start();
	   
	    try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void theRestExample() {
		ThreadGroup tgrp = new ThreadGroup("Thread Group");
		
		Thread t1 = new Thread(tgrp, new AdminThread2());
		t1.setDaemon(false);
		
		Thread t2 = new Thread(tgrp, "t2");
		Thread t3 = new Thread(tgrp, new AdminThread2(), "t3");
		Thread t4 = new Thread(tgrp, new AdminThread2(), "t3", 0);
		//Thread t5 = new Thread(tgrp, new AdminThread2(), "t3", 0, true);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//t5.start();
		
		int count = Thread.activeCount();
		System.out.println("currently active threads = " + count);
		
		Thread th[] = new Thread[count];
		Thread.enumerate(th);
		for (int i = 0; i < count; i++) {
			System.out.println(i + ": " + th[i]);
		}
		
		Map<Thread, StackTraceElement[]> m = Thread.getAllStackTraces();
		System.out.println(m);
		
		Thread.dumpStack();
		
		try {
			t1.checkAccess();
			System.out.println("You have permission to modify");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		joinExample();
		interruptExemple();
		aliveExemple();
		priorityExameple();
		nameIdStatusExample();
		yieldExample();
		exceptionHandlerExample();
		spinWaitExample();
		theRestExample();
	}
}

class AdminThread2 implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		
		System.out.println("daemon = " + t.isDaemon());
		
		ClassLoader c = t.getContextClassLoader();
		t.setContextClassLoader(c);
		System.out.println("Class = " + c.getClass());
		System.out.println("Parent = " + c.getParent());
		
		System.out.println("Holds Lock = " + Thread.holdsLock(this));
		synchronized (this) {
			System.out.println("Holds Lock = " + Thread.holdsLock(this));
		}
		
		System.out.println(t.getThreadGroup());
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
	}
}

abstract class Task implements Runnable {

    volatile boolean canStart;

    void start() {
    	this.canStart = true;
    }
}

class NormalTask extends Task {

    @Override
    public void run() {
    	while (!this.canStart) {

    	}
      
    	System.out.println("Done!");
    }
}

class SpinWaitTask extends Task {

    @Override
    public void run() {
    	while (!this.canStart) {
    		//Thread.onSpinWait();
    	}
      
    	System.out.println("Done!");
    }
}

class AdminThread implements Runnable {
	public void run() {
		throw new RuntimeException();
	}
}

class YieldThread implements Runnable {
	public void run() {
		for(int i = 1; i < 100000; i++) {
			if ((i % 1000) == 0) {
				System.out.println(Thread.currentThread().getName() + " yielding control...");
				
				/* causes the currently executing thread object to temporarily
				pause and allow other threads to execute */
				Thread.yield();
			}
		}
	}
}

class SimpleThread extends Thread {
	   
	boolean waiting = true;
	boolean ready = false;

	public void run() {
		String thrdName = Thread.currentThread().getName();
		System.out.println(thrdName + " starting.");
		
		int i = 0;
		while(waiting) {
			if(i % 3000000 == 0) {
				System.out.println("waiting:"+waiting); 
			}
			i++;
		}
		
		System.out.println("waiting...");
		startWait(); 

		try {
			Thread.sleep(1000);
		} catch(Exception exc) {
			System.out.println(thrdName + " interrupted.");
		}

		System.out.println(thrdName + " terminating.");
	}
	   
	synchronized void startWait() {
		try {
			while(!ready) wait();
		} catch(InterruptedException exc) {
			System.out.println("wait() interrupted");
		}
	}
	
	synchronized void notice() {
		ready = true;
		notify();
	}
}

class SimplePriorities extends Thread {

	private int countDown = 30;
	private volatile double d = 0; 
	
	public SimplePriorities(int priority) {
		setPriority(priority);
		start();
	}
	
	public String toString() {
		return super.toString() + ": " + countDown + " : " + getPriority();
	}
	
	public void run() {
		while(true) {
			for(int i = 1; i < 10000000; i++) d = d + (Math.PI + Math.E) / (double)i;
			System.out.println(this);
			if(--countDown == 0) return;
		}
	}
} 

class MyThread extends Thread {

	boolean stop = false;
	
	public void run() {
		while (true) {
			int stop = ThreadLocalRandom.current().nextInt(0, 100000);
			if (stop == 666) {
				return;
			}
		}
	}
}

class GeneralInterrupt implements Runnable {
	
	public void run() {
		try {
			System.out.println("in run() - about to work");
			work();
	        System.out.println("in run() - back from work");
	    } catch (InterruptedException x) {
	        System.out.println("in run() - interrupted in work");
	        return;
	    }
		
		System.out.println("in run() - doing stuff after nap");
		System.out.println("in run() - leaving normally");
   	}
	   
	public void work() throws InterruptedException {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				if(Thread.interrupted()) {
					System.out.println("A isInterrupted()="+ Thread.currentThread().isInterrupted());
					Thread.sleep(2000);
					Thread.currentThread().interrupt();
					System.out.println("D isInterrupted()="+ Thread.currentThread().isInterrupted());
				}
				System.out.println("B isInterrupted()="+ Thread.currentThread().isInterrupted());
				Thread.sleep(2000);
	            System.out.println("C isInterrupted()="+ Thread.currentThread().isInterrupted());
	        }
	    }
	}
	
}
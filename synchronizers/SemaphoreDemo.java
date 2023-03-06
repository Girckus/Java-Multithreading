package synchronizers;

import java.util.Collection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo 
{ 

	public static void main(String args[]) throws InterruptedException 
	{ 
		exemplo01();
		exemplo02();
		exemplo03();
	}
	
	private static void exemplo01() throws InterruptedException 
	{ 
		Semaphore sem = new Semaphore(3, true); 
			
		System.out.println("is Fairness enabled : " + sem.isFair()); 
			
		sem.tryAcquire(2); 
		System.out.println("Available permits : " + sem.availablePermits()); 
		System.out.println("number of permits drain by Main thread : "	+ sem.drainPermits()); 
		sem.release(1); 
			
		MyThread mt1 = new MyThread(sem, 1); 
		MyThread mt2 = new MyThread(sem, 2); 
			
		mt1.start(); 
		mt2.start(); 

		System.out.println(sem.toString()); 
		mt1.join(); 
		mt2.join(); 
	}
	
	private static void exemplo02() throws InterruptedException 
	{ 
		MySemaphore sem = new MySemaphore(3); 
			
		System.out.println("is Fairness enabled : " + sem.isFair()); 
			
		sem.tryAcquire(); 
			
		MyThread mt1 = new MyThread(sem, 1); 
		MyThread mt2 = new MyThread(sem, 2); 
			
		mt1.start(); 
		mt2.start(); 

		System.out.println("Available permits : " + sem.availablePermits()); 
		sem.reducePermits(1);
		System.out.println("Available permits : " + sem.availablePermits()); 
		System.out.println(sem.getQueuedThreads().size());
		
		mt1.join(); 
		mt2.join(); 
	}
	
	private static void exemplo03() throws InterruptedException 
	{ 
		Semaphore sem1 = new Semaphore(3); 
		Semaphore sem2 = new Semaphore(3); 
		Semaphore sem3 = new Semaphore(3); 
			
		sem1.tryAcquire(2); 
		sem2.tryAcquire(2, 10, TimeUnit.SECONDS); 
		sem3.tryAcquire(10, TimeUnit.SECONDS); 
		System.out.println("Available permits 1: " + sem1.availablePermits()); 
		System.out.println("Available permits 2: " + sem2.availablePermits()); 
		System.out.println("Available permits 3: " + sem3.availablePermits()); 
			
		MyThread mt1 = new MyThread(sem1, 1); 
		MyThread mt2 = new MyThread(sem1, 2); 
		MyThread mt3 = new MyThread(sem1, 3); 
		MyThread mt4 = new MyThread(sem2, 4);
		MyThread mt5 = new MyThread(sem2, 5); 
		MyThread mt6 = new MyThread(sem2, 6);
		MyThread mt7 = new MyThread(sem3, 7); 
		MyThread mt8 = new MyThread(sem3, 8);
		MyThread mt9 = new MyThread(sem3, 9); 
		
		mt1.start(); 
		mt2.start(); 
		mt3.start(); 
		mt4.start(); 
		mt5.start(); 
		mt6.start(); 
		mt7.start(); 
		mt8.start(); 
		mt9.start(); 

		mt1.join(); 
		mt2.join(); 
		mt3.join(); 
		mt4.join(); 
		mt5.join(); 
		mt6.join(); 
		mt7.join(); 
		mt8.join(); 
		mt9.join();
	}
}

class MySemaphore extends Semaphore {

	private static final long serialVersionUID = 1L;

	public MySemaphore(int permits) {
		super(permits, true);
	}

	@Override
	protected void reducePermits(int reduction) {
		System.out.println("in reducePermits");
		super.reducePermits(reduction);
	}

	@Override
	protected Collection<Thread> getQueuedThreads() {
		System.out.println("in getQueuedThreads");
		return super.getQueuedThreads();
	}
	
}

class MyThread extends Thread 
{ 
	Semaphore sem; 
	Integer threadName; 
	
	public MyThread(Semaphore sem, Integer threadName) 
	{ 
		super(threadName.toString()); 
		this.sem = sem; 
		this.threadName = threadName; 
	} 
	
	@Override
	public void run() { 
		System.out.println(threadName + " is waiting for a permit."); 

		try { 
			if(threadName < 3) {
				sem.acquire();
			} else if (threadName < 5) {
				sem.acquireUninterruptibly();
			} else if (threadName < 7) {
				sem.acquire(2);
			} else {
				sem.acquireUninterruptibly(2);
			}
		} catch (InterruptedException e) { 
			e.printStackTrace(); 
		} 
			
		System.out.println(threadName + " gets a permit"); 

		for(int i=0; i < 2; i++) 
		{ 
			boolean b = sem.hasQueuedThreads(); 
			if(b) 
				System.out.println("Length of Queue : " + sem.getQueueLength());
			try { 
				Thread.sleep(10); 
			} catch (InterruptedException e) { 
				e.printStackTrace(); 
			} 
		} 
	
		System.out.println(threadName + " releases the permit."); 
		
		if(threadName < 7) {
			sem.release(); 
		} else {
			sem.release(2); 
		}
		
	} 
} 
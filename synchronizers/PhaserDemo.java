package synchronizers;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class PhaserDemo {

	public static void main(String[] args) throws Exception {
		exemplo01();
		exemplo02();
		exemplo03();
		exemplo04();
		exemplo05();
		exemplo06();
	}
	
	public static void exemplo01() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);
		
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));
		 
		ph.arriveAndAwaitAdvance();
		  
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction("thread-4", ph));
		executorService.submit(new LongRunningAction("thread-5", ph));
		
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndAwaitAdvance();
		 
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndDeregister();
	}
	
	public static void exemplo02() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser();
		ph.bulkRegister(1);
		  
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));
		 
		ph.arrive();
		  
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction("thread-4", ph));
		executorService.submit(new LongRunningAction("thread-5", ph));
		
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		ph.arriveAndAwaitAdvance();
		  
		ph.arriveAndDeregister();
	}
	
	public static void exemplo03() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);
		Phaser ph1 = new Phaser(ph, 1);
		Phaser ph2 = new Phaser(ph, 1);
		Phaser ph3 = new Phaser(ph);
		ph3.bulkRegister(1);
		
		System.out.println(ph.toString());
		System.out.println(ph1.toString() + " " + ph1.getParent() + " " + ph1.getRoot());
		System.out.println(ph2.toString() + " " + ph1.getParent() + " " + ph2.getRoot());
		System.out.println(ph3.toString() + " " + ph1.getParent() + " " + ph3.getRoot());
		
		executorService.submit(new LongRunningAction("thread-1", ph1));
		executorService.submit(new LongRunningAction("thread-2", ph2));
		executorService.submit(new LongRunningAction("thread-3", ph3));
		 
		ph.arrive();
		  
		System.out.println(ph.toString());
		System.out.println(ph1.toString() + " " + ph1.getParent() + " " + ph1.getRoot());
		System.out.println(ph2.toString() + " " + ph1.getParent() + " " + ph2.getRoot());
		System.out.println(ph3.toString() + " " + ph1.getParent() + " " + ph3.getRoot());
		
		executorService.submit(new LongRunningAction("thread-4", ph2));
		executorService.submit(new LongRunningAction("thread-5", ph3));
		
		System.out.println(ph.toString());
		System.out.println(ph1.toString() + " " + ph1.getParent() + " " + ph1.getRoot());
		System.out.println(ph2.toString() + " " + ph1.getParent() + " " + ph2.getRoot());
		System.out.println(ph3.toString() + " " + ph1.getParent() + " " + ph3.getRoot());
		
		ph.arrive();
		  
		ph.arriveAndDeregister();
	}
	
	public static void exemplo04() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(2);
		
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction2("thread-1", ph));
		executorService.submit(new LongRunningAction2("thread-2", ph));
		executorService.submit(new LongRunningAction2("thread-3", ph));
		executorService.submit(new LongRunningAction2("thread-4", ph));
		executorService.submit(new LongRunningAction2("thread-5", ph));
		executorService.submit(new LongRunningAction2("thread-6", ph));
		executorService.submit(new LongRunningAction2("thread-7", ph));
		executorService.submit(new LongRunningAction2("thread-8", ph));
		
		ph.arriveAndAwaitAdvance();
		
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndDeregister();
	}
	
	public static void exemplo05() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Phaser ph = new Phaser(1);
		
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction3("thread-1", ph, 1));
		executorService.submit(new LongRunningAction3("thread-2", ph, 2));
		executorService.submit(new LongRunningAction3("thread-3", ph, 3));
		 
		ph.arriveAndAwaitAdvance();
		  
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction3("thread-4", ph, 4));
		executorService.submit(new LongRunningAction3("thread-5", ph, 5));
		
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndAwaitAdvance();
		 
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndDeregister();
	}
	
	public static void exemplo06() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		MyPhaser ph = new MyPhaser();
		ph.register();
		
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction("thread-1", ph));
		executorService.submit(new LongRunningAction("thread-2", ph));
		executorService.submit(new LongRunningAction("thread-3", ph));
		 
		ph.arriveAndAwaitAdvance();
		  
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		executorService.submit(new LongRunningAction("thread-4", ph));
		executorService.submit(new LongRunningAction("thread-5", ph));
		
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndAwaitAdvance();
		 
		System.out.println(ph.toString());
		System.out.println(ph.getPhase() + " " + ph.getRegisteredParties() + " " + ph.getUnarrivedParties() + " " + ph.getArrivedParties());
		
		ph.arriveAndDeregister();
	}
	
	static class LongRunningAction implements Runnable {
		private String threadName;
	    private Phaser phaser;
	 
	    LongRunningAction(String threadName, Phaser phaser) {
	    	this.threadName = threadName;
	        this.phaser = phaser;
	    }
	 
	    @Override
	    public void run() {
	    	
	    	System.out.println(threadName);
	    	
	        try {
	            Thread.sleep(20);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        phaser.arriveAndDeregister();
	    }
	}
	
	static class LongRunningAction2 implements Runnable {
		private String threadName;
	    private Phaser phaser;
	 
	    LongRunningAction2(String threadName, Phaser phaser) {
	    	this.threadName = threadName;
	        this.phaser = phaser;
	    }
	 
	    @Override
	    public void run() {
	    	
	    	if(threadName.equals("thread-2")) {
	    		phaser.awaitAdvance(2);
	    	} else {
	    		phaser.arriveAndAwaitAdvance();
	    	}
	    	
	    	if(threadName.equals("thread-3")) {
	    		try {
					phaser.awaitAdvanceInterruptibly(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	    	} else {
	    		phaser.arriveAndAwaitAdvance();
	    	}
	    	
	    	if(threadName.equals("thread-4")) {
	    		try {
					phaser.awaitAdvanceInterruptibly(4, 2, TimeUnit.SECONDS);
				} catch (InterruptedException | TimeoutException e) {
					e.printStackTrace();
				}
	    	} else {
	    		phaser.arriveAndAwaitAdvance();
	    	}
	    	
	    	System.out.println(threadName + " " + phaser.getPhase());
	    	
	        try {
	            Thread.sleep(20);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        phaser.arriveAndDeregister();
	    }
	}
	
	static class LongRunningAction3 implements Runnable {
		private String threadName;
	    private Phaser phaser;
	    private int number;
	    
	    LongRunningAction3(String threadName, Phaser phaser, int number) {
	    	this.threadName = threadName;
	        this.phaser = phaser;
	        this.number = number;
	    }
	 
	    @Override
	    public void run() {
	    	
	    	System.out.println(threadName);
	    	System.out.println(phaser.isTerminated());
	    	
	        try {
	            Thread.sleep(20);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	        	Random rand = new Random();
	        	int t = rand.nextInt(5);
	        	
	        	if(number == t) {
	        		System.out.println(threadName + " force termination");
	        		phaser.forceTermination();
	        	}
	        }
	        
	        System.out.println(phaser.isTerminated());
	        phaser.arriveAndDeregister();
	    }
	}
	
	static class MyPhaser extends Phaser {

		protected boolean onAdvance(int phase, int registeredParties) {
			System.out.println("MyPhaser " + phase + " " + registeredParties);
			return super.onAdvance(phase, registeredParties);
		}
		
	}
}
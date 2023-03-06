package synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierDemo 
{ 

	public static void main(String args[]) throws InterruptedException 
	{ 
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 1 executed ");
		    }
		};
		Runnable barrier2Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 2 executed ");
		    }
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);
		CyclicBarrier barrier3 = new CyclicBarrier(2);
		CyclicBarrier barrier4 = new CyclicBarrier(2);

		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable barrierRunnable3 = new CyclicBarrierRunnable(barrier3, barrier4);
		CyclicBarrierRunnable barrierRunnable4 = new CyclicBarrierRunnable(barrier3, barrier4);
		
		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
		new Thread(barrierRunnable3).start();
		new Thread(barrierRunnable4).start();
	}
	
}

class CyclicBarrierRunnable implements Runnable{

    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("getNumberWaiting barrier 1: " + barrier1.getNumberWaiting());
            System.out.println("getNumberWaiting barrier 2: " + barrier2.getNumberWaiting());
            System.out.println("getParties barrier 1: " + barrier1.getParties());
            System.out.println("getParties barrier 2: " + barrier2.getParties());
            System.out.println(Thread.currentThread().getName() +  " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println("getNumberWaiting barrier 1: " + barrier1.getNumberWaiting());
            System.out.println("getNumberWaiting barrier 2: " + barrier2.getNumberWaiting());
            System.out.println("getParties barrier 1: " + barrier1.getParties());
            System.out.println("getParties barrier 2: " + barrier2.getParties());
            System.out.println(Thread.currentThread().getName() +  " waiting at barrier 2");
            this.barrier2.await(10, TimeUnit.SECONDS);
            this.barrier1.reset();

            System.out.println("getNumberWaiting barrier 1: " + barrier1.getNumberWaiting());
            System.out.println("getNumberWaiting barrier 2: " + barrier2.getNumberWaiting());
            System.out.println("getParties barrier 1: " + barrier1.getParties());
            System.out.println("getParties barrier 2: " + barrier2.getParties());
            System.out.println(Thread.currentThread().getName() +  " waiting at barrier 1 again");
			this.barrier1.await();
            
			System.out.println(Thread.currentThread().getName() +  " done!");
            System.out.println("isBroken barrier 1: " + barrier1.isBroken());
            System.out.println("isBroken barrier 2: " + barrier2.isBroken());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
			e.printStackTrace();
		}
    }
}
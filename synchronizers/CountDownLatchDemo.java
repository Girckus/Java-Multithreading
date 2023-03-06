package synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountDownLatchDemo 
{ 

	public static void main(String args[]) throws InterruptedException 
	{ 
		final CountDownLatch latch = new CountDownLatch(3);

		Thread cacheService = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, latch));

		cacheService.start();
		alertService.start();
		validationService.start();

		try{
            latch.await();
            System.out.println("All services are up, Application is starting now");
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
		
		System.out.println(latch.toString());
		
		Thread cacheService2 = new Thread(new Service("CacheService", 1000, latch));
		Thread alertService2 = new Thread(new Service("AlertService", 1000, latch));
		Thread validationService2 = new Thread(new Service("ValidationService", 1000, latch));
		
		cacheService2.start();
		alertService2.start();
		validationService2.start();
		try{
            latch.await(1, TimeUnit.SECONDS);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
		
		System.out.println("Main Thread finished");
	}
	
}

class Service implements Runnable {
	private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

 
    public Service(String name, int timeToStart, CountDownLatch latch){
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

 
    @Override
    public void run() {
    	try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println( name + " is Up");
        System.out.println("Count: " + latch.getCount());
        System.out.println(latch.toString());
        latch.countDown();
    }
}
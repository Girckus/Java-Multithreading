package future;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RunnableScheduledFutureDemo {

	public static void main(String[] args) throws Exception {
		ScheduledThreadPoolExecutor scheduledPool = new ScheduledThreadPoolExecutor(2);

		RunnableScheduledFuture<String> sf1 = (RunnableScheduledFuture<String>) scheduledPool.schedule(new CallableTask("Teste Callable1"), 4, TimeUnit.SECONDS);
		RunnableScheduledFuture<String> sf2 = (RunnableScheduledFuture<String>) scheduledPool.schedule(new CallableTask("Teste Callable2"), 6, TimeUnit.SECONDS);
		RunnableScheduledFuture<String> sf3 = (RunnableScheduledFuture<String>) scheduledPool.schedule(new CallableTask("Teste Callable3"), 8, TimeUnit.SECONDS);
		RunnableScheduledFuture<String> sf4 = (RunnableScheduledFuture<String>) scheduledPool.schedule(new CallableTask("Teste Callable4"), 10, TimeUnit.SECONDS);
	    
		System.out.println("sf1 periodic " + sf1.isPeriodic());
		System.out.println("sf2 periodic " + sf2.isPeriodic());
		System.out.println("sf3 periodic " + sf3.isPeriodic());
		System.out.println("sf4 periodic " + sf4.isPeriodic());
		
	    System.out.println("Callable1 returned : " + sf1.get());
	    System.out.println("Callable2 returned : " + sf2.get());
	    System.out.println("Callable3 returned : " + sf3.get());
	    System.out.println("Callable4 returned : " + sf4.get());
	    
	    scheduledPool.shutdown();
	}
	
}

class CallableTask implements Callable<String> {
	String message;

	public CallableTask(String message)
	{
		this.message = message;
	}

	@Override
	public String call() throws Exception
	{
		Thread.sleep(1000);
		return message;
	}
}
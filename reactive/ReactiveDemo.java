package reactive;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveDemo {

	 public static void main(String[] args) throws InterruptedException {
	 
		 SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
		 
		 Subscriber<String> subscriber1 = new Subscriber<>() {
	            private Subscription subscription;

	            @Override
	            public void onSubscribe(Subscription subscription) {
	                this.subscription = subscription;
	                subscription.request(1);
	            }
	            
	            @Override
	            public void onNext(String item) {
	                System.out.println("Subscriber 1: " + item);
	                subscription.request(1);
	            }

	            @Override
	            public void onError(Throwable throwable) {
	                throwable.printStackTrace();
	            }

	            @Override
	            public void onComplete() {
	                System.out.println("Subscriber 1 completed!");
	            }
		 };
		 
		 Subscriber<String> subscriber2 = new Subscriber<>() {
	            private Subscription subscription;

	            @Override
	            public void onSubscribe(Subscription subscription) {
	                this.subscription = subscription;
	                subscription.request(1);
	            }

	            @Override
	            public void onNext(String item) {
	                System.out.println("Subscriber 2: " + item.toUpperCase());
	                
	                if(item.equals("finish2")) {
	                	subscription.cancel();
	                } else {
	                	subscription.request(1);
	                }
	            }
	            
	            @Override
	            public void onError(Throwable throwable) {
	                throwable.printStackTrace();
	            }

	            @Override
	            public void onComplete() {
	                System.out.println("Subscriber 2 completed!");
	            }
		 };
		 
		 publisher.subscribe(subscriber1);
	     publisher.subscribe(subscriber2);

	     publisher.submit("hello");
	     publisher.submit("world");
	     publisher.submit("!");
	     publisher.submit("finish2");
	     publisher.submit("Hello");
	     publisher.submit("Again");
	     
	     Thread.sleep(1000);
	     publisher.close();
	 
	 }
	
}
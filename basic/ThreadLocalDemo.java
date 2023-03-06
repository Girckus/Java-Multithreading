package basic;

import java.util.Random;

public class ThreadLocalDemo implements Runnable {

	private static int n = 0;
	private static int x = 0;
	
	private static ThreadLocal<Integer> t = new ThreadLocal<>() {
		protected Integer initialValue() {
			return n++;
		}
	};
	
	private static ThreadLocal<Integer> t2 = ThreadLocal.<Integer>withInitial( () -> {return x+2; });
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalDemo obj = new ThreadLocalDemo();
        for(int i=0 ; i<10; i++){
            Thread thread = new Thread(obj, "T-"+i);
            thread.start();
        }
	}
	
	@Override
	public void run() {
		try {
            Thread.sleep(new Random().nextInt(10000));
            
			System.out.println("A - " + Thread.currentThread().getName() + ": " + t.get() + " " + t2.get());
				
			if(n == 2) {
				t.set(10);
			}
			
			if(n == 4) {
				t2.set(20);
			}

			System.out.println("B - " + Thread.currentThread().getName() + ": " + t.get() + " " + t2.get());
			
			if(Thread.currentThread().getName().equals("T-7")) {
				t2.remove();
			}
			
			System.out.println("C - " + Thread.currentThread().getName() + ": " + t.get() + " " + t2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}	
}
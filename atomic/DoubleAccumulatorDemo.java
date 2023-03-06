package atomic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.DoubleAccumulator;

public class DoubleAccumulatorDemo {
	
	public static void main(String[] args) throws InterruptedException {
		DoubleAccumulator acc = new DoubleAccumulator(((x,y) -> x * y), 1);
		
		Random rand = new Random();
		
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                for (int c = 0; c < 100; c++) {
                	acc.accumulate(rand.nextDouble() + 0.55);
                }
            });
        }
        
        es.shutdown();

        System.out.println(acc.get());
        System.out.println(acc.doubleValue());
        System.out.println(acc.floatValue());
        System.out.println(acc.longValue());
        System.out.println(acc.intValue());
        System.out.println(acc.toString());
        
        acc.reset();
        System.out.println(acc.getThenReset());
        System.out.println(acc.get());
	}

}
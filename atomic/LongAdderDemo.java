package atomic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
	
	public static void main(String[] args) throws InterruptedException {
		LongAdder add = new LongAdder();
		
		Random rand = new Random();
		
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.execute(() -> {
                for (int c = 0; c < 100; c++) {
                	if(rand.nextBoolean()) {
                		add.add(rand.nextLong());
                	} else if(rand.nextBoolean()) {
                		add.increment();
                	} else {
                		add.decrement();
                	}
                }
            });
        }
        
        es.shutdown();

        System.out.println(add.sum());
        System.out.println(add.doubleValue());
        System.out.println(add.floatValue());
        System.out.println(add.longValue());
        System.out.println(add.intValue());
        System.out.println(add.toString());
        
        add.reset();
        System.out.println(add.sumThenReset());
        System.out.println(add.sum());
	}

}
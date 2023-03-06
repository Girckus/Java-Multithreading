package future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorCompletionServiceDemo {

	public static void main(String[] args) throws Exception {
		BlockingQueue<Future<String>> queue = new ArrayBlockingQueue<>(5);
		
		ExecutorCompletionService<String> executor1 = new ExecutorCompletionService<>(Executors.newFixedThreadPool(2));
		ExecutorCompletionService<String> executor2 = new ExecutorCompletionService<>(Executors.newFixedThreadPool(2), queue);
		ExecutorCompletionService<String> executor3 = new ExecutorCompletionService<>(Executors.newCachedThreadPool());
		
		executor1.submit(new MyTask(1));
		executor1.submit(new MyTask(2));
		executor1.submit(new MyTask(3));
		executor1.submit(new MyTask(4));
		executor1.submit(new MyTask(5));
		
		executor2.submit(() -> System.out.println("Task 1x"), "Task 1a");
		executor2.submit(() -> System.out.println("Task 2x"), "Task 2a");
		executor2.submit(() -> System.out.println("Task 3x"), "Task 3a");
		executor2.submit(() -> System.out.println("Task 4x"), "Task 4a");
		executor2.submit(() -> System.out.println("Task 5x"), "Task 5a");
		
		executor3.submit(() -> System.out.println("Task 6x"), "Task 6a");
		executor3.submit(() -> System.out.println("Task 7x"), "Task 7a");
		executor3.submit(() -> System.out.println("Task 8x"), "Task 8a");
		executor3.submit(() -> System.out.println("Task 9x"), "Task 9a");
		executor3.submit(() -> System.out.println("Task 10x"), "Task 10a");
		
		for (int i = 0; i < 5; i++) {
			System.out.println("ExecutorCompletionService 1: " + i);
            Future<String> future = executor1.take(); // Bloqueante
            String result = future.get();
            System.out.println("Result: " + result);
        }
		
		for (int i = 0; i < 5; i++) {
			System.out.println("ExecutorCompletionService 2: " + i);
            Future<String> future = executor2.poll();
            String result = future.get();
            System.out.println("Result: " + result);
        }
		
		for (int i = 0; i < 5; i++) {
			System.out.println("ExecutorCompletionService 3: " + i);
            Future<String> future = executor3.poll(1, TimeUnit.SECONDS);
            String result = future.get();
            System.out.println("Result: " + result);
        }
		
	}
	
}

class MyTask implements Callable<String> {
    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        System.out.println("Task " + id + " started");
        Thread.sleep(5000); // Simula um processamento demorado
        System.out.println("Task " + id + " completed");
        return "Task " + id;
    }
}
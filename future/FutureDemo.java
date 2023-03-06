package future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureDemo {

	public static void main(String[] args) throws Exception {
		Random rand = new Random();
		
		ExecutorService threadpool = Executors.newFixedThreadPool(3);
		
		GerarNumeroAleatorio tarefa1 = new GerarNumeroAleatorio();
        GerarNumeroAleatorio tarefa2 = new GerarNumeroAleatorio();
        GerarNumeroAleatorio tarefa3 = new GerarNumeroAleatorio();
		
        System.out.println("Processando a tarefa ...");
        Future<Integer> futureT1 = threadpool.submit(tarefa1);
        Future<Integer> futureT2 = threadpool.submit(tarefa2);
        Future<Integer> futureT3 = threadpool.submit(tarefa3);		
        
        while (!futureT1.isDone() && !futureT2.isDone() && !futureT3.isDone()) {
            System.out.println("As tarefas ainda não foram processadas!");
            Thread.sleep(600); // sleep for 600 millisecond before checking again
            
            if(rand.nextBoolean()) {
            	futureT1.cancel(true);
            }
            
            if(rand.nextBoolean()) {
            	futureT2.cancel(true);
            }
            
            if(rand.nextBoolean()) {
            	futureT3.cancel(true);
            }
        }
        
        System.out.println("Tarefa completa!");
        
        if(futureT1.isCancelled()) {
        	System.out.println("Tarefa 1 cancelada");
        } else {
        	System.out.println("Tarefa 1: " +  futureT1.get(100, TimeUnit.SECONDS));
        }
        
        if(futureT2.isCancelled()) {
        	System.out.println("Tarefa 2 cancelada");
        } else {
        	System.out.println("Tarefa 2: " +  futureT2.get());
        }
        
        if(futureT3.isCancelled()) {
        	System.out.println("Tarefa 3 cancelada");
        } else {
        	System.out.println("Tarefa 3: " +  futureT3.get());
        }
        
        threadpool.shutdown();
	}
	
}

class GerarNumeroAleatorio implements Callable<Integer> {
	  
    @Override
    public Integer call() throws InterruptedException {
    	Random rand = new Random();
        Integer number = rand.nextInt(100);
        
        Thread.sleep(1000);
        
        return number;
    }
     
}
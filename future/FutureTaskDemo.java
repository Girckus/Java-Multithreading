package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
        
		PowerCalculationTask powerCalculationTask = new PowerCalculationTask(2, 10);
		System.out.println(powerCalculationTask);
		
		Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // Simulate some long running computation
                Thread.sleep(5000);
                return 42;
            }
        };
        
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        
        executor.execute(powerCalculationTask);
        executor.execute(futureTask);

        // Do some other work while the computation is running
        System.out.println("Doing some other work...");
        
        System.out.println("isCancelled? " + futureTask.isCancelled());
        System.out.println("isDone? " + futureTask.isDone());
        
        // Wait for the computation to finish and get the result
        Integer result = futureTask.get();
        System.out.println("The result is: " + result);
        System.out.println("isDone? " + futureTask.isDone());
        
        powerCalculationTask.cancel(false);
        
        Double resultDouble = powerCalculationTask.get(100, TimeUnit.SECONDS);
        System.out.println(resultDouble);
        
        executor.shutdown();
	}
	
}

class PowerCalculationTask extends FutureTask<Double> {
    private double base;
    private int exponent;

    public PowerCalculationTask(double base, int exponent) {
        super(() -> Math.pow(base, exponent));
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    protected void done() {
        try {
            System.out.printf("%f^%d = %f%n", base, exponent, get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void set(Double d) {
        System.out.println("Tarefa retornou: " + d);
        super.set(d);
    }

    @Override
    protected void setException(Throwable t) {
        // implementação do método setException()
        System.out.println("Tarefa lançou exceção: " + t.getMessage());
        super.setException(t);
    }

    @Override
    protected boolean runAndReset() {
        // implementação do método runAndReset()
        System.out.println("runAndReset");
        return super.runAndReset();
    }
}
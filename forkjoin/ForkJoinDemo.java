package forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

 public class ForkJoinDemo extends RecursiveTask<Long> {
 	private static final long serialVersionUID = 1L;
	 
 	private static final int THRESHOLD = 1000; // Tamanho do subarray mínimo para paralelizar
    private final int[] array;
    private final int start;
    private final int end;

    public ForkJoinDemo(int[] array) {
        this(array, 0, array.length);
    }

    private ForkJoinDemo(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
	
    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) { // Caso base: tamanho do subarray é menor que o limite de paralelismo
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else { // Divisão do problema em subproblemas menores
            int mid = start + length / 2;
            ForkJoinDemo leftTask = new ForkJoinDemo(array, start, mid);
            ForkJoinDemo rightTask = new ForkJoinDemo(array, mid, end);
            leftTask.fork();
            long rightSum = rightTask.compute();
            long leftSum = leftTask.join();
            return leftSum + rightSum;
        }
    }
    
	 public static void main(String[] args) throws ExecutionException {
		 int[] array = new int[100_000_000]; // Array grande para demonstrar a eficiência do paralelismo
	     for (int i = 0; i < array.length; i++) {
	    	 array[i] = i;
	     }

	     ForkJoinPool pool = ForkJoinPool.commonPool();
	     ForkJoinDemo task = new ForkJoinDemo(array);
	     long sum = pool.invoke(task);
	     System.out.println("Soma do array: " + sum);
	 }  
	 
}
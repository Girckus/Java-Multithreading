package future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFutureDemo {

	public static void main(String[] args) throws Exception {
		exemplo01();
		exemplo02();
		exemplo03();
		exemplo04();
		exemplo05();
		exemplo06();
		exemplo07();
		exemplo08();
		exemplo09();
		exemplo10();
		exemplo11();
		exemplo12();
		exemplo13();
		exemplo14();
	}

	static void exemplo01() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    System.out.println("I'll run in a separate thread than the main thread.");
		});
		
		System.out.println("isCancelled: " + future.isCancelled());
		System.out.println("isCompletedExceptionally: " + future.isCompletedExceptionally());
		System.out.println("isDone: " + future.isDone());
		System.out.println("getNumberOfDependents: " + future.getNumberOfDependents());
		System.out.println("toString(): " + future.toString());
	}
	
	static void exemplo02() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Result of the asynchronous computation";
		    }
		});
		
		System.out.println(future.get());
	}
	
	static void exemplo03() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Do";
		    }
		}).thenApply(ret -> {
			return ret + " You";
		}).thenAccept(got -> {
			System.out.println(got + " got it?");
		}).thenRun(() -> {
			System.out.println("CompletableFuture");
		});		
		
		future.get();
	}
	
	static void exemplo04() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Test 1";
		    }
		}).thenApplyAsync(ret -> {
			   return ret + " Test 02";
		}).thenApplyAsync(ret -> {
			   return ret + " Test 03";
		}, executor).thenAcceptAsync(ret -> {
			System.out.println(ret + " Test 04");
		}).thenAcceptAsync(got -> {
			System.out.println(got + " Test 05");
		}, executor).thenRunAsync(() -> {
			System.out.println("Test 06");
		}).thenRunAsync(() -> {
			System.out.println("Test 07");
		}, executor);		
		
		future.get();
		executor.shutdown();
	}
	
	static void exemplo05() throws InterruptedException, ExecutionException {
		String message = "Message";
		
		CompletableFuture<String> cf = CompletableFuture.completedFuture(message)
														.thenApply(s -> s.toUpperCase())
														.thenCompose(upper -> CompletableFuture.completedFuture(message)
																							   .thenApply(s -> s.toLowerCase())
																							   .thenApply(s -> upper + s));
		System.out.println(cf.join());
	}
	
	static void exemplo06() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Completable";
		    }
		});	
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Future";
		    }
		});	
		
		CompletableFuture<String> future3 = future1.thenCombine(future2, (str1, str2) -> (str1 + " " + str2));
		CompletableFuture<String> future4 = future1.thenCombineAsync(future2, (str1, str2) -> (str1 + " " + str2));
		
		System.out.println(future3.get());
		System.out.println(future4.get());
	}
	
	static void exemplo07() throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 1";
		    }
		});	
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 2";
		    }
		});	
		
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 3";
		    }
		});	
		
		List<CompletableFuture<String>> futures = new ArrayList<>();
		futures.add(future1);
		futures.add(future2);
		futures.add(future3);
		
		CompletableFuture<String> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[3])).thenApplyAsync(list -> {
			return futures.stream()
					      .map(fut -> fut.join())
					      .map( Object::toString )
				          .collect(Collectors.joining(" "));
		});
		
		System.out.println(allFutures.get(10, TimeUnit.SECONDS));
	}
	
	static void exemplo08() throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 1";
		    }
		});	
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 2";
		    }
		});	
		
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 3";
		    }
		});	
		
		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1, future2, future3);
		
		System.out.println(anyOfFuture.get());
	}
	
	static void exemplo09() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 1";
		    }
		});	
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture 2";
		    }
		});	
		
		CompletableFuture<Void> future3 = future1.thenAcceptBoth(future2, (str1, str2) -> System.out.println(str1 + " " + str2));
		CompletableFuture<Void> future4 = future1.thenAcceptBothAsync(future2, (str1, str2) -> System.out.println(str1 + " " + str2));
		CompletableFuture<Void> future5 = future1.thenAcceptBothAsync(future2, (str1, str2) -> System.out.println(str1 + " " + str2), executor);
		
		System.out.println(future3.get());
		System.out.println(future4.get());
		System.out.println(future5.get());
		
		executor.shutdown();
	}
	
	static void exemplo10() throws InterruptedException, ExecutionException {
		CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
			int age = ThreadLocalRandom.current().nextInt(-10, 100);
			
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).exceptionally(ex -> {
		    System.out.println("Oops! We have an exception - " + ex.getMessage());
		    return "Unknown!";
		});
		
		System.out.println(maturityFuture.join());
	}
	
	static void exemplo11() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		CompletableFuture<String> maturityFuture1 = CompletableFuture.supplyAsync(() -> {
			int age = ThreadLocalRandom.current().nextInt(-10, 100);
			
		    if(age < 18) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).handle((res, ex) -> {
		    if(ex != null) {
		        System.out.println("Oops! We have an exception - " + ex.getMessage());
		        return "Unknown!";
		    }
		    return res;
		});
		
		CompletableFuture<String> maturityFuture2 = CompletableFuture.supplyAsync(() -> {
			int age = ThreadLocalRandom.current().nextInt(-10, 100);
			
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).handleAsync((res, ex) -> {
		    if(ex != null) {
		        System.out.println("Oops! We have an exception - " + ex.getMessage());
		        return "Unknown!";
		    }
		    return res;
		});
		
		CompletableFuture<String> maturityFuture3 = CompletableFuture.supplyAsync(() -> {
			int age = ThreadLocalRandom.current().nextInt(-10, 100);
			
		    if(age < 0) {
		        throw new IllegalArgumentException("Age can not be negative");
		    }
		    if(age > 18) {
		        return "Adult";
		    } else {
		        return "Child";
		    }
		}).handleAsync((res, ex) -> {
		    if(ex != null) {
		        System.out.println("Oops! We have an exception - " + ex.getMessage());
		        return "Unknown!";
		    }
		    return res;
		}, executor);
		
		System.out.println(maturityFuture1.get());
		System.out.println(maturityFuture2.getNow("Get Now"));
		System.out.println(maturityFuture3.get());
		
		executor.shutdown();
	}
	
	static void exemplo12() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "CompletableFuture 1");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "CompletableFuture 2");
		
		CompletableFuture<Void> future3 = future2.acceptEither(future1, (val)-> {
			System.out.println("val: "+val);
        });
		
		CompletableFuture<Void> future4 = future1.acceptEitherAsync(future2, (val)-> {
			System.out.println("val: "+val);
        });
		
		CompletableFuture<Void> future5 = future2.acceptEitherAsync(future1, (val)-> {
			System.out.println("val: "+val);
        }, executor);
		
		System.out.println(future3.join());
		System.out.println(future4.join());
		System.out.println(future5.join());
		
		executor.shutdown();
	}
	
	static void exemplo13() throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "CompletableFuture 1");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "CompletableFuture 2");

		CompletableFuture<String> future3 = future2.applyToEither(future1, (val)-> {
			return "val: " + val;
        });
		
		CompletableFuture<String> future4 = future1.applyToEitherAsync(future2, (val)-> {
			return "val: " + val;
        });
		
		CompletableFuture<String> future5 = future2.applyToEitherAsync(future1, (val)-> {
			return "val: " + val;
        }, executor);
		
		System.out.println(future3.get());
		System.out.println(future4.get());
		System.out.println(future5.get());
		
		executor.shutdown();
	}

	static void exemplo14() throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
		    @Override
		    public String get() {
		        try {
		            TimeUnit.SECONDS.sleep(20);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "CompletableFuture";
		    }
		});
		
		future1.completeExceptionally(new RuntimeException("completed exceptionally"));
		
		try {
			future1.join();
			System.out.println("Should have thrown an exception");
	    } catch(CompletionException ex) {
	    	System.out.println("completed exceptionally " + ex.getCause().getMessage());
	    }
	}	
}
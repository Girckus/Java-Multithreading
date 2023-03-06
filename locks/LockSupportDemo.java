package locks;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
	
	public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread is starting.");
            LockSupport.park(); // a thread é pausada aqui
            System.out.println("Thread is resuming.");
        });
        
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2 is starting.");
            LockSupport.parkNanos(1000); // a thread é pausada aqui
            System.out.println("Thread2 is resuming.");
        });
        
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread3 is starting.");
            LockSupport.parkUntil(1000l); // a thread é pausada aqui
            System.out.println("Thread3 is resuming.");
        });
        
        thread.start();
        thread2.start();
        thread3.start();
        
        try {
            Thread.sleep(1000); // aguarda 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        LockSupport.unpark(thread); // a thread é resumida aqui
        LockSupport.unpark(thread2); // a thread é resumida aqui
        LockSupport.unpark(thread3); // a thread é resumida aqui
    
        var str = "Teste";
        
        Thread thread4 = new Thread(() -> {
            LockSupport.park(str); // Bloqueia a thread com um objeto String como argumento
        });
        
        Thread thread5 = new Thread(() -> {
            LockSupport.parkNanos(str, 1000); // Bloqueia a thread com um objeto String como argumento
        });
        
        Thread thread6 = new Thread(() -> {
            LockSupport.parkUntil(str, 1000l); // Bloqueia a thread com um objeto String como argumento
        });
        
        thread4.start();
        thread5.start();
        thread6.start();
        
        Object blocker4 = LockSupport.getBlocker(thread4); // Recupera o objeto que está bloqueando a thread
        Object blocker5 = LockSupport.getBlocker(thread4); // Recupera o objeto que está bloqueando a thread
        Object blocker6 = LockSupport.getBlocker(thread4); // Recupera o objeto que está bloqueando a thread
        
        System.out.println("Thread 4 bloqueada por: " + blocker4); // Imprime o objeto que está bloqueando a thread
        System.out.println("Thread 5 bloqueada por: " + blocker5); // Imprime o objeto que está bloqueando a thread
        System.out.println("Thread 6 bloqueada por: " + blocker6); // Imprime o objeto que está bloqueando a thread
	}
	
}
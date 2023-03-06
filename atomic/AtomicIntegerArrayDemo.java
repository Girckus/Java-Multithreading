package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayDemo {
	
	public static void main(String[] args) {
        // cria uma instância de AtomicIntegerArray
        AtomicIntegerArray atomicInteger = new AtomicIntegerArray(10);

        // obtém o valor atual do AtomicIntegerArray
        int currentValue = atomicInteger.get(2);
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicIntegerArray de forma atômica
        int newValue = 20;
        atomicInteger.set(1 ,newValue);
        System.out.println("Novo valor: " + atomicInteger.get(1));
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        int oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        boolean success = atomicInteger.compareAndSet(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getAcquire(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        int witness = atomicInteger.compareAndExchangeAcquire(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + atomicInteger.getAndSet(1, newValue));
        System.out.println("Novo valor: " + atomicInteger.get(1));
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        witness = atomicInteger.compareAndExchangeRelease(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicInteger.getOpaque(1));
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        success = atomicInteger.compareAndSet(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.lazySet(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setOpaque(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getOpaque(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setPlain(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setRelease(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }

        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setPlain(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setRelease(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setPlain(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.setRelease(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.weakCompareAndSetAcquire(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.weakCompareAndSetPlain(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.weakCompareAndSetRelease(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerArray
        atomicInteger.weakCompareAndSetVolatile(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);
        System.out.println(atomicInteger.getAndAdd(1, 10));
        System.out.println(atomicInteger.addAndGet(1, 10));
        System.out.println(atomicInteger.getAndIncrement(1));
        System.out.println(atomicInteger.incrementAndGet(1));
        System.out.println(atomicInteger.decrementAndGet(1));
        System.out.println(atomicInteger.getAndDecrement(1));
        
        int result = atomicInteger.accumulateAndGet(3, 5, (prev, next) -> prev * next);
        System.out.println(result);
        
        result = atomicInteger.getAndAccumulate(3, 5, (prev, next) -> prev * next);
        System.out.println(result);
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);

        oldValue = atomicInteger.getAndUpdate(5, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicInteger.get(5));
        
        // cria uma instância de AtomicIntegerArray
        atomicInteger = new AtomicIntegerArray(10);

        oldValue = atomicInteger.updateAndGet(5, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicInteger.get(5));
    }
}
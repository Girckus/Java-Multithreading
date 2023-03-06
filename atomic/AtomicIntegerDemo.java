package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo { 
	public static void main(String[] args) {
        // cria uma instância de AtomicInteger
        AtomicInteger atomicInteger = new AtomicInteger(10);

        // obtém o valor atual do AtomicInteger
        int currentValue = atomicInteger.get();
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicInteger de forma atômica
        int newValue = 20;
        atomicInteger.set(newValue);
        System.out.println("Novo valor: " + atomicInteger.get());
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        int oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        boolean success = atomicInteger.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getAcquire());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        int witness = atomicInteger.compareAndExchangeAcquire(oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + atomicInteger.getAndSet(newValue));
        System.out.println("Novo valor: " + atomicInteger.get());
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        witness = atomicInteger.compareAndExchangeRelease(oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicInteger.getOpaque());
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        success = atomicInteger.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.lazySet(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setOpaque(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getOpaque());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }

        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.weakCompareAndSetAcquire(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.weakCompareAndSetPlain(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.weakCompareAndSetRelease(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicInteger
        atomicInteger.weakCompareAndSetVolatile(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicInteger.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.getAndAdd(10));
        System.out.println(atomicInteger.addAndGet(10));
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.decrementAndGet());
        System.out.println(atomicInteger.getAndDecrement());
        System.out.println(atomicInteger.doubleValue());
        System.out.println(atomicInteger.floatValue());
        System.out.println(atomicInteger.intValue());
        System.out.println(atomicInteger.longValue());
        
        int result = atomicInteger.accumulateAndGet(3, (prev, next) -> prev * next);
        System.out.println(result);
        
        result = atomicInteger.getAndAccumulate(3, (prev, next) -> prev * next);
        System.out.println(result);
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);

        oldValue = atomicInteger.getAndUpdate(x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicInteger.get());
        
        // cria uma instância de AtomicInteger
        atomicInteger = new AtomicInteger(10);

        oldValue = atomicInteger.updateAndGet(x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicInteger.get());
    }
}
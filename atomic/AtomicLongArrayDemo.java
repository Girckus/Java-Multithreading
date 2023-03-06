package atomic;

import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayDemo {
	
	public static void main(String[] args) {
        // cria uma instância de AtomicLongArray
        AtomicLongArray atomicLong = new AtomicLongArray(10);

        // obtém o valor atual do AtomicLongArray
        long currentValue = atomicLong.get(2);
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicLongArray de forma atômica
        long newValue = 20;
        atomicLong.set(1 ,newValue);
        System.out.println("Novo valor: " + atomicLong.get(1));
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        long oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        boolean success = atomicLong.compareAndSet(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getAcquire(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        long witness = atomicLong.compareAndExchangeAcquire(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + atomicLong.getAndSet(1, newValue));
        System.out.println("Novo valor: " + atomicLong.get(1));
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        witness = atomicLong.compareAndExchangeRelease(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLong.getOpaque(1));
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        success = atomicLong.compareAndSet(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.lazySet(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setOpaque(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getOpaque(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setPlain(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setRelease(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }

        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setPlain(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setRelease(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setPlain(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.setRelease(1, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.weakCompareAndSetAcquire(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.weakCompareAndSetPlain(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.weakCompareAndSetRelease(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongArray
        atomicLong.weakCompareAndSetVolatile(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);
        System.out.println(atomicLong.getAndAdd(1, 10));
        System.out.println(atomicLong.addAndGet(1, 10));
        System.out.println(atomicLong.getAndIncrement(1));
        System.out.println(atomicLong.incrementAndGet(1));
        System.out.println(atomicLong.decrementAndGet(1));
        System.out.println(atomicLong.getAndDecrement(1));
        
        long result = atomicLong.accumulateAndGet(3, 5, (prev, next) -> prev * next);
        System.out.println(result);
        
        result = atomicLong.getAndAccumulate(3, 5, (prev, next) -> prev * next);
        System.out.println(result);
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);

        oldValue = atomicLong.getAndUpdate(5, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLong.get(5));
        
        // cria uma instância de AtomicLongArray
        atomicLong = new AtomicLongArray(10);

        oldValue = atomicLong.updateAndGet(5, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLong.get(5));
    }
}
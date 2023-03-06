package atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
	
	public static void main(String[] args) {
        // cria uma instância de AtomicLong
        AtomicLong atomicLong = new AtomicLong(10);

        // obtém o valor atual do AtomicLong
        long currentValue = atomicLong.get();
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicLong de forma atômica
        long newValue = 20;
        atomicLong.set(newValue);
        System.out.println("Novo valor: " + atomicLong.get());
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        long oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        boolean success = atomicLong.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getAcquire());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        long witness = atomicLong.compareAndExchangeAcquire(oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + atomicLong.getAndSet(newValue));
        System.out.println("Novo valor: " + atomicLong.get());
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        witness = atomicLong.compareAndExchangeRelease(oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLong.getOpaque());
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        success = atomicLong.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.lazySet(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setOpaque(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getOpaque());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }

        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.weakCompareAndSetAcquire(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.weakCompareAndSetPlain(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.weakCompareAndSetRelease(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        oldValue = 10;
        newValue = 20;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLong
        atomicLong.weakCompareAndSetVolatile(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicLong.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);
        System.out.println(atomicLong.getAndAdd(10));
        System.out.println(atomicLong.addAndGet(10));
        System.out.println(atomicLong.getAndIncrement());
        System.out.println(atomicLong.incrementAndGet());
        System.out.println(atomicLong.decrementAndGet());
        System.out.println(atomicLong.getAndDecrement());
        System.out.println(atomicLong.doubleValue());
        System.out.println(atomicLong.floatValue());
        System.out.println(atomicLong.intValue());
        System.out.println(atomicLong.longValue());
        
        long result = atomicLong.accumulateAndGet(3, (prev, next) -> prev * next);
        System.out.println(result);
        
        result = atomicLong.getAndAccumulate(3, (prev, next) -> prev * next);
        System.out.println(result);
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);

        oldValue = atomicLong.getAndUpdate(x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLong.get());
        
        // cria uma instância de AtomicLong
        atomicLong = new AtomicLong(10);

        oldValue = atomicLong.updateAndGet(x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLong.get());
    }
}
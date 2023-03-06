package atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanDemo { 
	public static void main(String[] args) {
        // cria uma instância de AtomicBoolean
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);

        // obtém o valor atual do AtomicBoolean
        boolean currentValue = atomicBoolean.get();
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicBoolean de forma atômica
        boolean newValue = false;
        atomicBoolean.set(newValue);
        System.out.println("Novo valor: " + atomicBoolean.get());
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        boolean oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        boolean success = atomicBoolean.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getAcquire());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        success = atomicBoolean.compareAndExchangeAcquire(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + atomicBoolean.getAndSet(newValue));
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        success = atomicBoolean.compareAndExchangeRelease(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getOpaque());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        success = atomicBoolean.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.lazySet(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setOpaque(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getOpaque());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }

        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setPlain(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.setRelease(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.weakCompareAndSetAcquire(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.weakCompareAndSetPlain(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.weakCompareAndSetRelease(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.getPlain());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicBoolean
        atomicBoolean = new AtomicBoolean(true);
        oldValue = true;
        newValue = false;
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicBoolean
        atomicBoolean.weakCompareAndSetVolatile(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicBoolean.get());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
    }
}
package atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo { 
	public static void main(String[] args) {
        // cria uma instância de AtomicReference
        AtomicReference<String> atomicReference = new AtomicReference<>("String 01");

        String oldValue = "oldValue";
        String newValue = "newValue";
        
        // obtém o valor atual do AtomicReference
        String currentValue = atomicReference.get();
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicReference de forma atômica
        atomicReference.set(newValue);
        System.out.println("Novo valor: " + atomicReference.get());
        
        // cria uma instância de AtomicReference
        atomicReference =  new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        boolean success = atomicReference.compareAndSet(oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicReference.getAcquire());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        String witness = atomicReference.compareAndExchangeAcquire(oldValue, newValue);

        System.out.println("Valor antigo: " + atomicReference.getAndSet(newValue + " Test"));
        System.out.println("Novo valor: " + witness);
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        witness = atomicReference.compareAndExchangeRelease(oldValue, newValue);
        System.out.println("Novo valor: " + witness);
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
       
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        witness = atomicReference.compareAndExchange(oldValue, newValue);
        System.out.println("Novo valor: " + witness);
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.lazySet(newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get());
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.setOpaque(newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicReference.getOpaque());
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.setPlain(newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain());
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);

        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.setRelease(newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get());

        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.setPlain(newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain());
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.weakCompareAndSetAcquire(oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain());
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.weakCompareAndSetPlain(oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain());
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.weakCompareAndSetRelease(oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain());
        
        // cria uma instância de AtomicReference
        atomicReference = new AtomicReference<>(oldValue);
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReference
        atomicReference.weakCompareAndSetVolatile(oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain());
        
        String result = atomicReference.accumulateAndGet("String 02", (prev, next) -> prev + " - " +  next);
        System.out.println(result);
        
        result = atomicReference.getAndAccumulate("String 03", (prev, next) -> prev + " - " + next);
        System.out.println(result);
        
        atomicReference = new AtomicReference<>(oldValue);
        oldValue = atomicReference.getAndUpdate(x -> x + " Teste");
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get());
        
        atomicReference = new AtomicReference<>(oldValue);
        oldValue = atomicReference.updateAndGet(x -> x + " Teste");
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get());
    }
}
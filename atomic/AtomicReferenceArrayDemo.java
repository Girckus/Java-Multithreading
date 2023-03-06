package atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicReferenceArrayDemo {
	
	public static void main(String[] args) {
		String oldValue = "oldValue";
		String newValue = "newValue";
		
        // cria uma instância de AtomicReferenceArray
        AtomicReferenceArray<String> atomicReference = new AtomicReferenceArray<>(new String[] {"Teste 1", "Tesste 2", "Teste 3"});

        // obtém o valor atual do AtomicReferenceArray
        String currentValue = atomicReference.get(2);
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicReferenceArray de forma atômica
        atomicReference.set(1, newValue);
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        boolean success = atomicReference.compareAndSet(1, oldValue, newValue);

        if (success) {
            System.out.println("Valor antigo: " + oldValue);
            System.out.println("Novo valor: " + atomicReference.getAcquire(1));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        String witness = atomicReference.compareAndExchangeAcquire(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + atomicReference.getAndSet(1, newValue));
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        witness = atomicReference.compareAndExchangeRelease(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getOpaque(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        witness = atomicReference.compareAndExchange(1, oldValue, newValue);

        System.out.println("Valor witness: " + witness);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.lazySet(1, newValue);

        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.setOpaque(1, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getOpaque(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.setPlain(1, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.getPlain(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.setRelease(1, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(1));

        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.weakCompareAndSetAcquire(1, oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.weakCompareAndSetPlain(1, oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.weakCompareAndSetRelease(1, oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicReferenceArray
        atomicReference.set(1, oldValue);
        atomicReference.weakCompareAndSetVolatile(1, oldValue, newValue);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(1));
        
        // cria uma instância de AtomicReferenceArray
        System.out.println(atomicReference.length());
        
        String result = atomicReference.accumulateAndGet(2, " Teste 01", (prev, next) -> prev + " - " + next);
        System.out.println(result);
        
        result = atomicReference.getAndAccumulate(2, " Teste 02", (prev, next) -> prev + " - " + next);
        System.out.println(result);
        
        oldValue = atomicReference.getAndUpdate(0, x -> x + " Teste 04");
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(0));
        
        oldValue = atomicReference.updateAndGet(0, x -> x + " Teste 03");
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReference.get(0));
    }
}
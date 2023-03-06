package atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicReferenceFieldUpdaterDemo {
	
	public static void main(String[] args) {
		Value value = new Value("String 01");
		
        // cria uma inst�ncia de AtomicReferenceFieldUpdater
        AtomicReferenceFieldUpdater<Value, String> atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Value.class, String.class, "value");

        // obt�m o valor atual do AtomicReferenceFieldUpdater
        String currentValue = atomicReferenceFieldUpdater.get(value);
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicReferenceFieldUpdater de forma at�mica
        atomicReferenceFieldUpdater.set(value, "String 02");
        System.out.println("Novo valor: " + atomicReferenceFieldUpdater.get(value));
        
        // Realiza uma opera��o de troca at�mica de valor no objeto AtomicReferenceFieldUpdater
        boolean success = atomicReferenceFieldUpdater.compareAndSet(value, "String 02", "String 03");

        if (success) {
            System.out.println("Valor antigo: " + value);
            System.out.println("Novo valor: " + atomicReferenceFieldUpdater.get(value));
        } else {
            System.out.println("Valor antigo n�o encontrado.");
        }
        
        atomicReferenceFieldUpdater.lazySet(value, "String 04");
        System.out.println("Novo valor: " + atomicReferenceFieldUpdater.get(value));
        
        // Realiza uma opera��o de troca at�mica de valor no objeto AtomicReferenceFieldUpdater
        success = atomicReferenceFieldUpdater.weakCompareAndSet(value, "String 04", "String 05");

        if (success) {
            System.out.println("Novo valor: " + atomicReferenceFieldUpdater.get(value));
        } else {
            System.out.println("Valor antigo n�o encontrado.");
        }
        
        String result = atomicReferenceFieldUpdater.accumulateAndGet(value, "String 05", (prev, next) -> prev + " - " + next);
        System.out.println(result);
        
        result = atomicReferenceFieldUpdater.getAndAccumulate(value, "String 06", (prev, next) -> prev + " - " + next);
        System.out.println(result);
        
        String oldValue = atomicReferenceFieldUpdater.getAndUpdate(value, x -> x + " Teste 01");
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReferenceFieldUpdater.get(value));
        
        oldValue = atomicReferenceFieldUpdater.updateAndGet(value, x -> x + " Teste 02");
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicReferenceFieldUpdater.get(value));
    }
	
	public static class Value {
		private volatile String value;
		
		public Value(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Value [value=" + value + "]";
		}
	}
}
package atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class AtomicLongFieldUpdaterDemo {
	
	public static void main(String[] args) {
		Value value = new Value(1);
        // cria uma instância de AtomicLongFieldUpdater
        AtomicLongFieldUpdater<Value> atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(Value.class, "value");

        // obtém o valor atual do AtomicLongFieldUpdater
        long currentValue = atomicLongFieldUpdater.get(value);
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicLongFieldUpdater de forma atômica
        value = new Value(5);
        atomicLongFieldUpdater.set(value, 10);
        System.out.println("Novo valor: " + atomicLongFieldUpdater.get(value));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongFieldUpdater
        boolean success = atomicLongFieldUpdater.compareAndSet(value, 10, 20);

        if (success) {
            System.out.println("Valor antigo: " + value);
            System.out.println("Novo valor: " + atomicLongFieldUpdater.get(value));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        atomicLongFieldUpdater.lazySet(value, 250);
        System.out.println("Novo valor: " + atomicLongFieldUpdater.get(value));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicLongFieldUpdater
        success = atomicLongFieldUpdater.weakCompareAndSet(value, 250, 350);

        if (success) {
            System.out.println("Novo valor: " + atomicLongFieldUpdater.get(value));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        System.out.println(atomicLongFieldUpdater.getAndAdd(value, 100));
        System.out.println(atomicLongFieldUpdater.addAndGet(value, 101));
        System.out.println(atomicLongFieldUpdater.getAndIncrement(value));
        System.out.println(atomicLongFieldUpdater.incrementAndGet(value));
        System.out.println(atomicLongFieldUpdater.decrementAndGet(value));
        System.out.println(atomicLongFieldUpdater.getAndDecrement(value));
        System.out.println(atomicLongFieldUpdater.getAndSet(value, 130));
        
        long result = atomicLongFieldUpdater.accumulateAndGet(value, 30, (prev, next) -> prev * next);
        System.out.println(result);
        
        result = atomicLongFieldUpdater.getAndAccumulate(value, 3, (prev, next) -> prev * next);
        System.out.println(result);
        
        long oldValue = atomicLongFieldUpdater.getAndUpdate(value, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLongFieldUpdater.get(value));
        
        oldValue = atomicLongFieldUpdater.updateAndGet(value, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicLongFieldUpdater.get(value));
    }
	
	public static class Value {
		private volatile long value;
		
		public Value(long value) {
			this.value = value;
		}

		public long getValue() {
			return value;
		}

		public void setValue(long value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Value [value=" + value + "]";
		}
	}
}
package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterDemo {
	
	public static void main(String[] args) {
		Value value = new Value(1);
        // cria uma instância de AtomicIntegerFieldUpdater
        AtomicIntegerFieldUpdater<Value> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Value.class, "value");

        // obtém o valor atual do AtomicIntegerFieldUpdater
        int currentValue = atomicIntegerFieldUpdater.get(value);
        System.out.println("Valor atual: " + currentValue);

        // atualiza o valor do AtomicIntegerFieldUpdater de forma atômica
        value = new Value(5);
        atomicIntegerFieldUpdater.set(value, 10);
        System.out.println("Novo valor: " + atomicIntegerFieldUpdater.get(value));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerFieldUpdater
        boolean success = atomicIntegerFieldUpdater.compareAndSet(value, 10, 20);

        if (success) {
            System.out.println("Valor antigo: " + value);
            System.out.println("Novo valor: " + atomicIntegerFieldUpdater.get(value));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        atomicIntegerFieldUpdater.lazySet(value, 250);
        System.out.println("Novo valor: " + atomicIntegerFieldUpdater.get(value));
        
        // Realiza uma operação de troca atômica de valor no objeto AtomicIntegerFieldUpdater
        success = atomicIntegerFieldUpdater.weakCompareAndSet(value, 250, 350);

        if (success) {
            System.out.println("Novo valor: " + atomicIntegerFieldUpdater.get(value));
        } else {
            System.out.println("Valor antigo não encontrado.");
        }
        
        System.out.println(atomicIntegerFieldUpdater.getAndAdd(value, 100));
        System.out.println(atomicIntegerFieldUpdater.addAndGet(value, 101));
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(value));
        System.out.println(atomicIntegerFieldUpdater.incrementAndGet(value));
        System.out.println(atomicIntegerFieldUpdater.decrementAndGet(value));
        System.out.println(atomicIntegerFieldUpdater.getAndDecrement(value));
        System.out.println(atomicIntegerFieldUpdater.getAndSet(value, 130));
        
        int result = atomicIntegerFieldUpdater.accumulateAndGet(value, 30, (prev, next) -> prev * next);
        System.out.println(result);
        
        result = atomicIntegerFieldUpdater.getAndAccumulate(value, 3, (prev, next) -> prev * next);
        System.out.println(result);
        
        int oldValue = atomicIntegerFieldUpdater.getAndUpdate(value, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicIntegerFieldUpdater.get(value));
        
        oldValue = atomicIntegerFieldUpdater.updateAndGet(value, x -> x + 5);
        System.out.println("Valor antigo: " + oldValue);
        System.out.println("Novo valor: " + atomicIntegerFieldUpdater.get(value));
    }
	
	public static class Value {
		private int value;
		
		public Value(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Value [value=" + value + "]";
		}
	}
}
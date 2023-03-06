package atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo { 
	public static void main(String[] args) {
        String initialRef = "Initial value";
        int initialMark = 1;
        AtomicStampedReference<String> atomicStampedRef = new AtomicStampedReference<>(initialRef, initialMark);

        String newRef = "New value";
        int newMark = 2;
        int[] marked = {3};
        String currentRef = atomicStampedRef.get(marked);
        System.out.format("Reference is '%s' and stamp is %s%n", currentRef, marked[0]);
        
        boolean exchanged = atomicStampedRef.compareAndSet(initialRef, newRef, initialMark, newMark);
        System.out.format("Value was%s exchanged%n", exchanged ? "" : " not");

        atomicStampedRef.set("Teste", 5);
        int stamp = atomicStampedRef.getStamp();
        String currentRef2 = atomicStampedRef.getReference();
        System.out.format("Reference is '%s' and stamp is %s%n", currentRef2, stamp);
        
        exchanged = atomicStampedRef.weakCompareAndSet(initialRef, newRef, initialMark, newMark);
        System.out.format("Value was%s exchanged%n", exchanged ? "" : " not");
        
        exchanged = atomicStampedRef.attemptStamp(initialRef, 4);
        System.out.format("Stamp was%s exchanged%n", exchanged ? "" : " not");
        
    }
}
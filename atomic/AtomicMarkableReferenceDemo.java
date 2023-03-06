package atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceDemo { 
	public static void main(String[] args) {
        String initialRef = "Initial value";
        boolean initialMark = true;
        AtomicMarkableReference<String> atomicMarkableRef = new AtomicMarkableReference<>(initialRef, initialMark);

        String newRef = "New value";
        boolean newMark = false;
        boolean[] marked = {true}; // needs to be an array to be passed to the method
        String currentRef = atomicMarkableRef.get(marked); // retrieves the current reference and mark
        System.out.format("Reference is '%s' and mark is %s%n", currentRef, marked[0]); // prints "Reference is 'Initial value' and mark is true"

        boolean exchanged = atomicMarkableRef.compareAndSet(initialRef, newRef, initialMark, newMark);
        System.out.format("Value was%s exchanged%n", exchanged ? "" : " not"); // prints "Value was exchanged"

        marked[0] = true; // resets the mark to the initial value
        String currentRef2 = atomicMarkableRef.getReference();
        System.out.format("Reference is '%s' and mark is %s%n", currentRef2, marked[0]); // prints "Reference is 'New value' and mark is false"
        
        exchanged = atomicMarkableRef.weakCompareAndSet(initialRef, newRef, initialMark, newMark);
        System.out.format("Value was%s exchanged%n", exchanged ? "" : " not"); // prints "Value was exchanged"
        
        atomicMarkableRef.set(newRef, true);
        System.out.println("isMarked " + atomicMarkableRef.isMarked());
    }
}
package Skillz;

/**
 * Note: This can be time-consuming, you may want to save it for the end.
 * Implement a subset of Java ArrayList class using the following template.
 * It should be thread-safe, and not use any classes from the java.util package.
 */

public class MyArrayList<T> {

    Object[] array= new Object[10];
    int idx = 0, size = 0;


    /**
     * The size of the list
     * @return the size
     */
    public int size() {
        // TODO: Implement
        return size;
    }

    /**
     * Gets the object at the index
     * @param idx The index
     * @return The object
     * @throws ArrayIndexOutOfBoundsException if OOB
     */
    public T get( int idx ) {
        // TODO: Implement
        if(idx > this.idx)
            throw new ArrayIndexOutOfBoundsException();
        else
            return (T) array[idx];
    }

    /**
     * Add the object to the end of the list.
     * @param o The object, may be null.
     */
    public void add( T o ) {
        // TODO: Implement
        array[idx] = o;
        idx++;
        size++;
    }

    /**
     * Removes the object at the index
     * @param idx The index.
     */
    public void remove( int idx ) {
        // TODO: Implement
        if (idx > this.idx)
            throw new ArrayIndexOutOfBoundsException();
        else {
            array[idx] = null;
            size--;
        }
    }

}

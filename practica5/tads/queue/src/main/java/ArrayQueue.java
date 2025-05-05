import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int size;
    private static final int MAX = 100;

    public ArrayQueue()
    {
        array = (T[]) new Object[MAX];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        if (size == MAX) {
            resize(2*MAX);
        }
        
        array[size] = e;
        size++;
    }

    public void resize(int tamaño)
    {
        if (tamaño < size ) {
            throw new IllegalArgumentException();
        }

        T[] copy = (T[]) new Object[tamaño];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        
        array = copy;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = array[0];
        int n = 0;
        while (n < size - 1) {
            array[n] = array[n + 1];
            n++; 
        }
        array[size - 1] = null;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return array[0];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext()
            {
                return index < size;
            }

            public T next()
            {
                if (isEmpty()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }

    @Override
    public boolean repOK() {
        if (size < 0 ) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res+= array[i];
            if (i < size - 1) {
                res+= ", ";
            }
        }
        res+= "]";
        return res;
    }
    
}

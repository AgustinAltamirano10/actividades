package pilainvertir;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Clase<T> implements Stack<T>, Iterable<T>{
    
    private T[] array;
    private int size;
    private static final int MAX = 10;

    public Clase()
    {
        array = (T[]) new Object[MAX];
        size = 0;
    }

    public Clase(int tamanio)
    {
        if (tamanio < 0) {
            throw new IllegalArgumentException();
        }
        array = (T[]) new Object[tamanio];
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void resize(int cantidad)
    {
        if (cantidad < 0) {
            throw new IllegalArgumentException();
        }

        T[] copy = (T[]) new Object[cantidad];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    @Override
    public void push(T e) {
        if (size == array.length) {
            resize(2*array.length);
        }

        array[size] = e;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        
        T data = array[size - 1];
        array[size - 1] = null;
        size--;
        return data;
    }


    @Override
    public T top() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return array[size - 1];
    }

    // lo recorre como una pila
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = size - 1;

            public boolean hasNext() {
                return index >= 0;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index--];
            }
        };
    }

    public String toString()
    {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res+= array[i];
            if (i < size - 1) {
                res = res + ", ";
            }
        }
        res = res + "]";
        return res;
    }

    public void invertirPila() {
        T[] aux = (T[]) new Object[array.length];
        int j = 0;
        while (!isEmpty()) {
            aux[j] = pop();
            j++;
        }
        for (int i = 0; i < j; i++) {
            push(aux[i]);
        }
    }
}    

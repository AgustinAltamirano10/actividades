import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueCircularArray<T> implements Queue<T> {

    private T[] array;
    private int first;
    private int last;
    private int size;
    private static final int MAX = 10;

    public QueueCircularArray()
    {
        array = (T[]) new Object[MAX];
        first = 0;
        last = 0;
        size = 0;
    }

    public QueueCircularArray(int cantidad)
    {
        if (cantidad < 0) {
            throw new IllegalArgumentException();
        }
        array = (T[]) new Object[cantidad];
        first = 0;
        last = 0;
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

    public void resize(int cantidad)
    {
        if (cantidad < 0) {
            throw new IllegalArgumentException();
        }
        
        T[] copy = (T[]) new Object[cantidad];
        for (int i = 0; i < size; i++) {
            copy[i] = array[(first + i) % array.length];
        }
        array = copy;
        first = 0;
        last = size;
    }

    @Override
    public void enqueue(T e) {
        if (size == array.length) {
            resize(2 * array.length);
        }

        array[last] = e;
        last = (last + 1) % array.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T data = array[first];
        array[first] = null;
        first = (first + 1) % array.length;
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return array[first];
    }

    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private int index = 0;

            public boolean hasNext()
            {
                return index < size;
            }

            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = array[(first + index) % array.length];
                index++;
                return data;
            }
        };
    }

    @Override
    public boolean repOK() {
        if (size < 0 || size > array.length) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[(first + i) % array.length] == null) {
                return false;
            }
        }
        return true;
    }
    
    public String toString()
    {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res = res + array[(first + i) % array.length];
            if (i < size - 1) {
                res = res + ", ";
            }
        }
        res = res + "]";
        return res;
    }

    public int getLength()
    {
        return array.length;
    }
    
    // MAIN
    public static void main(String[] args) {
        QueueCircularArray<Integer> cola = new QueueCircularArray<>(5);
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);
        System.out.println("Cola: " + cola.toString()); // [1, 2, 3, 4, 5]
        System.out.println("tope: " + cola.peek()); // 1
        cola.dequeue(); // 1
        System.out.println("Cola: " + cola.toString()); // [2, 3, 4, 5]
        System.out.println("tope:" + cola.peek()); // 2
        System.out.println("length: " + cola.getLength());
        System.out.println("size: " + cola.size());
        cola.enqueue(6);
        cola.enqueue(7);
        System.out.println("length: " + cola.getLength());
        System.out.println("size: " + cola.size());
        if (cola.repOK()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

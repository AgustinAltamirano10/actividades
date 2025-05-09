package tads.stack;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray<T> implements Stack<T>{

    private T[] array;
    private int size;
    private static final int MAX = 10;

    public StackArray()
    {
        array = (T[]) new Object[MAX];
        size = 0;
    }


    public StackArray(int cantidad)
    {
        if (cantidad < 0) {
            throw new IllegalArgumentException();
        }
        array = (T[]) new Object[cantidad];
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
            copy[i] = array[i];
        }
        array = copy;
    }

    @Override
    public void push(T e) {
        if (size == array.length) {
            resize(2 * array.length);
        }

        array[size] = e;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T data = array[size - 1];
        array[size - 1] = null;
        size--;
        return data;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return array[size - 1];
    }

    @Override
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
                return array[index++];
            }
        };
    }
    
    public int getLength()
    {
        return array.length;
    }

    public String toString()
    {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res = res + array[i];
            if (i < size - 1) {
                res = res + ", ";
            }
        }
        
        res = res + "]";
        return res; 
    }

    public boolean repOk()
    {
        if (size < 0 || size > array.length) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                return false;
            }
        }
        return true;
    }

    // Main
    public static void main(String[] args) {
        StackArray<Integer> array = new StackArray<>();
        array.push(0);
        array.push(1);
        array.push(2);
        array.push(3);
        System.out.println("tope: " + array.top()); // 3
        System.out.println("array: " + array.toString()); // [0, 1, 2, 3]
        System.out.println("lenth: " + array.getLength());
        array.pop(); // quito el 3
        System.out.println("\n array - 1: " + array.toString()); // [0, 1, 2]
        System.out.println("tope: " + array.top()); // 2
        array.push(3);
        array.push(4);
        array.push(5);
        array.push(6);
        array.push(7);
        array.push(8);
        array.push(9); // maximo 10
        System.out.println("array: " + array.toString());
        System.out.println("size: " + array.size());
        System.out.println("lenth: " + array.getLength());
        array.push(10);
        System.out.println("lenth: " + array.getLength());
        if (array.repOk()) {
            System.out.println("verdadero");
        } else {
            System.out.println("falso");
        }
    }

}

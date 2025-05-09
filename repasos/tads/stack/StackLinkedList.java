package tads.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinkedList<T> implements Stack<T> {
    
    private class Node<T> {
        Node next;
        T data;

        Node(T data){
            this.data = data;
        }
        
    }

    private Node<T> top;
    private int size;

    public StackLinkedList()
    {
        top = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(T e) {
        Node aux = new Node<T>(e);
        aux.next = top;
        top = aux;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return top.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private Node aux = top;
    
            public boolean hasNext()
            {
                return aux != null;
            }
    
            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
    
                T data = (T) aux.data;
                aux = aux.next;
                return data;
            }    
        };
    }
        
    public String toString()
    {
        String res = "[";
        Node aux = top;
        while (aux != null) {
            res = res + aux.data;
            if (aux.next != null) {
                res = res + ", ";
            }
            aux = aux.next;
        }
        res = res + "]";
        return res;
    }

    public boolean repOk()
    {
        if (size < 0) {
            return false;
        }

        int cantidadNodos = 0;
        Node aux = top;
        while (aux != null && cantidadNodos <= size) {
            aux = aux.next;
            cantidadNodos++;
        }

        if (cantidadNodos != size || aux != null) {
            return false;
        }

        return true;
    }

    // MAIN
    public static void main(String[] args) {
        StackLinkedList<Integer> pila = new StackLinkedList<>();
        pila.push(0);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println("array: " + pila.toString()); // [0, 1, 2, 3]
        System.out.println("tope: " + pila.top()); // 0
        pila.pop(); // quito el 3
        System.out.println("\n array - 1: " + pila.toString()); // [0, 1, 2]
        System.out.println("tope: " +pila.top()); // 1
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push(6);
        pila.push(7);
        pila.push(8);
        pila.push(9); // maximo 10
        System.out.println("array: " + pila.toString());
        System.out.println("size: " + pila.size());
        pila.push(10);
        if (pila.repOk()) {
            System.out.println("verdadero");
        } else {
            System.out.println("falso");
        }
    }
    
}

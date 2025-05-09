package tads.stack;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackDoublyLinkedList<T> implements Stack<T> {
    
    private class Node<T> {
        Node<T> next;
        Node<T> back;
        T data;

        Node(T data){
            this.data = data;
        }
        
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public StackDoublyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(T e)
    {
        Node aux = new Node<T>(e);
        aux.next = first;
        if (first == null) {
            last = aux;
            first = aux;
        } else {
            first.back = aux;
            first = aux;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.back = null;
        }
        size--;
        return data;
    }

    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return first.data;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private Node aux = first;
    
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
        Node aux = first;
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
        Node current = first;
        Node prev = null;
        while (current != null) {
            if (current.back != prev) {
                return false;
            }
            prev = current;
            current = current.next;
            cantidadNodos++;
        }

        return cantidadNodos == size;
    }

    // MAIN
    public static void main(String[] args) {
        StackDoublyLinkedList<Integer> pila = new StackDoublyLinkedList<>();
        pila.push(0);
        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println("array: " + pila.toString()); // [3, 2, 1, 0]
        System.out.println("tope: " + pila.top()); // 3
        pila.pop(); // quito el 1
        System.out.println("\n array - 1: " + pila.toString()); // [2, 1, 0]
        System.out.println("tope: " +pila.top()); // 2
        pila.push(4);
        pila.push(5);
        pila.push(6);
        pila.push(7);
        pila.push(8);
        pila.push(9);
        pila.push(10); // maximo 10
        System.out.println("array: " + pila.toString());
        System.out.println("size: " + pila.size());
        pila.push(10);
        if(pila.repOk()){
            System.out.println("verdadero");
        } else {
            System.out.println("falso");
        }
    }
    
}

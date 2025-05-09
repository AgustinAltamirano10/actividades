package colainvertir;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<T> implements Queue<T>{

    private class Node {
        Node next;
        Node back;
        T data;
        
        Node(T data) {
            this.data = data;
        }
    }
    
    private Node first;
    private Node last;
    private int size;

    public QueueLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(T e) {
        Node aux = new Node(e);
        if (isEmpty()) {
            first = aux;
            last = aux;
        } else {
            last.next = aux;
            aux.back = last;
            last = aux;
        }
        size++;
    }

    @Override
    public T dequeue() {
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            Node aux = first;

            public boolean hasNext()
            {
                return aux != null;
            }

            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = aux.data;
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
        if (isEmpty()) {
            return false;
        }

        Node aux = first;
        Node current = aux;
        int cantidadNodos = 0;
        while (aux != null && cantidadNodos < size && current != last) {
            current = aux;
            aux = aux.next;
            cantidadNodos++;
        }

        if (aux != null || cantidadNodos < size || current != last) {
            return false;
        }
        return true;
    }

    public void invertirCola() {
        if (isEmpty()) return;
    
        Node actual = first;
        Node temp = null;
    
        // Intercambiar next y back en cada nodo
        while (actual != null) {
            temp = actual.back;
            actual.back = actual.next;
            actual.next = temp;
            actual = actual.back; // antes era next, ahora es back
        }
    
        // Intercambiar los punteros first y last
        temp = first;
        first = last;
        last = temp;
    }
    
}
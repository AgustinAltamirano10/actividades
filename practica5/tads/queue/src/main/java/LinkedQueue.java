import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    
    private class Node {
        Node next;
        Node prev;
        T data;

        Node(T data){
            this.data = data;
        }
        
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedQueue()
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
        if (first == null) {
            first = new Node(e);
            last = first;
        } else {
            Node aux = new Node(e);
            last.next = aux;
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
        size--;
        if (isEmpty()) {
            last = null;
        }
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

            public boolean hasNext()
            {
                return current != null;
            }

            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public boolean repOK() {
        if (size < 0) {
            return false;
        }

        Node aux = first, prev = null;
        int cantidadDeNodos = 0;
        while (aux != null && cantidadDeNodos < size - 1 && prev != last) {
            prev = aux;
            aux = aux.next;
            cantidadDeNodos++;
        }

        if (aux != null || cantidadDeNodos < size - 1) {
            return false;
        }

        return true;
    }

    public String toString()
    {
        String res = "[";
        Node aux = first;
        while (aux != null) {
            res+= aux.data;
            if (aux.next != null) {
                res+= ", ";
            }
            aux = aux.next;
        }
        res+= "]";
        return res;
    }

}

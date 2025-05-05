import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedQueue<T> implements Queue<T> {

    private class Node {
        Node next;
        Node prev;
        T data;

        Node(T data)
        {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public DoublyLinkedQueue()
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
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        if (isEmpty()) {
            first = new Node(e);
            last = first;
        } else {
            Node aux = new Node(e);
            aux.prev = last;
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
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
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
                T data = aux.data;
                aux = aux.next;
                return data;
            }
        };
    }

    @Override
    public boolean repOK() {
        if (size < 0) {
            return false;
        }

        Node aux = first;
        int cantidadDeNodos = 0;
        while (aux != null && cantidadDeNodos < size - 1) {
            aux = aux.next;
            cantidadDeNodos++;
        }

        if (aux != null && cantidadDeNodos < size - 1) {
            return false;
        }

        return true;
    }
    
}

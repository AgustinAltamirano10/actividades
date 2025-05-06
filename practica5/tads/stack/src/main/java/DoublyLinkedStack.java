import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedStack<T> implements Stack<T> {


    private class Node {
        Node next;
        Node prev;
        T data;

        Node(T data) {
            this.data = data;
        }
        
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedStack()
    {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T e) {
        Node aux = new Node(e);
        aux.next = head;
        aux.prev = null;
        
        if (isEmpty()) {
            tail = aux;
        } else {
            head.prev = aux;
        }

        head = aux;
        size++;
    }

    @Override
    public T pop() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
    
            T data = head.data;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return data;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

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
    
    public String toString()
    {
        String res = "[";
        Node aux = head;
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

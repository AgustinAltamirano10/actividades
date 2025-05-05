import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinkedList<T> implements Stack<T> {
    
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top;
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
        Node aux = new Node(e);
        aux.next = top;
        top = aux;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila no tiene elementos");
        }

        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila no tiene elementos");
        }

        return top.data;
    }

    public Iterator<T> iterator()
    {
        return new Iterator<T>(){
            private Node current = top;

            public boolean hasNext()
            {
                return top != null;
            }

            public T next()
            {
                if (!hasNext()) {
                    throw new IllegalArgumentException("no hay mas elementos");
                }

                T data = current.data;
                current = current.next;
                return data;
            }

        };
    }

    /**
     * @post retorna un set con los elementos de la pila
     */
    public String toString()
    {
        String res = "[";
        Node aux = top;
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

    public boolean repOk()
    {
        if (size < 0) {
            return false;
        }
        
        int numberOfNodes = 0;
        Node curr = top;
        while (curr != null && numberOfNodes <= size) {
            numberOfNodes++;
            curr = curr.next;
        }

        if (numberOfNodes != size || curr != null) {
            return false;
        }
        return true;
    }
}


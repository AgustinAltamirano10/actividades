import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackDoublyLinkedList<T> implements Stack<T> {
    
    private class Node{
        Node next;
        Node prev;
        T data;

        Node(T data){
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public StackDoublyLinkedList(){
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
        return size == 0;
    }

    @Override
    public void push(T e) {
        Node aux = new Node(e);
        aux.next = head;

        if (head != null) {
            head.prev = aux; // conectamos el viejo head hacia atrás
        }

        head = aux;

        if (size == 0) {
            tail = aux; // en la primera inserción, head y tail son lo mismo
        }
        size++;
    }


    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T element = head.data;
        head = head.next;  // Movemos el head al siguiente nodo
        if (head == null) { // Si la pila ahora está vacía
            tail = null;
        } else {
            head.prev = null;  // Desconectamos el nodo anterior del nuevo head
        }
        size--;
        return element;
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

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }


    public String toString(){
        String res = "[";
        Node aux = head;
        while (aux != null) {
            res += aux.data;
            if (aux.next != null) {
                res += ", ";
            }
            aux = aux.next;
        }
        res += "]";
        return res;
    }
}

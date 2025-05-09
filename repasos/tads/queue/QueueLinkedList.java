import java.util.Iterator;
import java.util.NoSuchElementException;


public class QueueLinkedList<T> implements Queue<T> {
    
    private class Node<T> {
        Node<T> next;
        T data;

        Node(T data){
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;
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
        Node aux = new Node<T>(e);
        if (first == null) {
            first = aux;
        } else {
            last.next = aux;
        }
        last = aux;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
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
        return new Iterator<T>(){
            private Node<T> aux = first;

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
        
        int cantidadNodos = 0;
        Node aux = first;
        while (aux != null) {
            aux = aux.next;
            cantidadNodos++;
        }

        return cantidadNodos == size;
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
    //Main
        public static void main(String[] args) {
        QueueLinkedList<Integer> cola = new QueueLinkedList<>();
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
        System.out.println("size: " + cola.size());
        cola.enqueue(6);
        cola.enqueue(7);
        System.out.println("size: " + cola.size());
        if (cola.repOK()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}

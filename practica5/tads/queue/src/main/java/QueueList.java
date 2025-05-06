import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueList<T> implements Queue<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node first;
    private Node last;
    private int size;

    /**
     * @post Returns the number of elements in the queue.
     *       More formally, it satisfies: result = #this.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @post Returns true iff the queue contains no elements.
     *       More formally, it satisfies: result = #this = 0.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @post Adds element e to the end of the queue.
     *       More formally, it satisfies: this = old(this) ++ [e].
     */
    @Override
    public void enqueue(T e) {
        if (first == null) {
            first = new Node(e);
            first.next = null;
        } else {
            Node aux = first;
            while (aux.next != null) {
                aux = aux.next;
            }
            Node aux2 = new Node(e);
            aux.next = aux2;
            aux2.next = null;
        }
        size++;
    }

    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Removes and returns the item at the beggining of the queue.
     *       More formally, it satisfies:
     *       let old(this) = [e] ++ s1 |
     *       this = s1 && result = e.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Vacio");
        }

        T data = first.data;
        Node aux = first;
        first = aux.next;
        aux = null;

        return data;
    }

    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Returns the item at the beggining of the queue.
     *       More formally, it satisfies:
     *       let this = [e] ++ s1 | result = e.
     */
    @Override
    public T peek() {
        return first.data;
    }

    /**
     * @post Returns an iterator for the queue that iterates through
     *       the items in FIFO order.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the queue");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * @post Returns true if and only if the structure is a
     *       valid queue.
     */
    @Override
    public boolean repOK() {
        if (size < 0) {
            return false;
        }

        int numberOfNodes = 0;
        Node prev = null, curr = first;
        while (curr != null && numberOfNodes <= size && prev != null) {
            prev = curr;
            curr = curr.next;
            numberOfNodes++;
        }

        if (numberOfNodes != size || curr != null || prev != last) {
            return false;
        }

        return true;
    }

    /**
     * @post Returns a string representation of the queue. Implements
     *       the abstraction function. Hence, it represents the queue as a
     *       sequence "[o1, o2,..., on]".
     */
    public String toString() {
        String res = "[";
        Node aux = first;
        while (aux != null) {
            res = res + aux.data;
            if (aux.next != null) {
                res = res + ", ";
            }
        }
        res = res + "]";
        return res;
    }
    
    public static void main(String[] args) {
        QueueList<String> l = new QueueList<>();
        QueueList<String> l1 = new QueueList<>();
        // Es un palindromo
        l.enqueue("n");
        l.enqueue("e");
        l.enqueue("u");
        l.enqueue("q");
        l.enqueue("u");
        l.enqueue("e");
        l.enqueue("n");

        // No es un palindromo
        l1.enqueue("n");
        l1.enqueue("e");
        l1.enqueue("u");
        l1.enqueue("z");
        l1.enqueue("z");
        l1.enqueue("e");
        l1.enqueue("n");

        boolean var2 = l1.palindromo();
        boolean var = l.palindromo();
        if (var) {
            System.out.println("####################################");
            System.out.println("Es un palindromo");
            System.out.println("####################################");
        } else {
            System.out.println("####################################");
            System.out.println("No es un palindromo");
        }

        if (var2) {
            System.out.println("####################################");
            System.out.println("Es un palindromo");
            System.out.println("####################################");
        } else {
            System.out.println("####################################");
            System.out.println("No es un palindromo");
        }
    }
}


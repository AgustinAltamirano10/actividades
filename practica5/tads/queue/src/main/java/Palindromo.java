public class Palindromo<T> {
        
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node first;
    private int size;

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
    public boolean palindromo() {
        if (isEmpty()) return false;
            
        Node aux = first, aux2 = first;
        int n = size();
        int j;
        
        while (aux2.next != null) { // Avanzo hacia el ultimo elemento
            aux2 = aux2.next;
        }
        
        while ((aux2.next != aux) && (aux != aux2)) {
            if (!aux.data.equals(aux2.data)) {
                return false;
            }
        
            aux = aux.next;
            aux2 = first;
            j = 1;
            while (j < n - 1) {
                aux2 = aux2.next;
                j++;
            }
            n--;
        }
        return true;
    }
}
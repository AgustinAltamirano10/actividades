

public class LinkedList<T> implements List<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    /**
     * @post Creates an empty List.
     *   More formally, it satisfies: this = [].
     */
    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * @post Returns true iff the list contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @post Returns true iff the list contains element e.
     *   More formally, it satisfies:
     *   result = exists o | o in this && e.equals(o).
     */
    public boolean contains(T e) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * @post Appends element e to the end of this list.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void add(T e) {
            if (head == null) {
                head = new Node(e);
                head.next = null;
                size++;
            } else {
                Node aux = head;
                while (aux.next != null) {
                    aux = aux.next;
                }
        
                Node aux2 = new Node(e);
                aux2.next = null;
                aux.next = aux2;
                size++;
            }
    }

    @Override
    public boolean remove(T e) {
        Node aux = head;

        if (aux.data.equals(e)) {
            head = head.next;
            return true;
        }

        while (aux.next != null) {
            if (aux.next.data.equals(e) || aux.data.equals(e)) {
                Node aux2 = aux.next;
                aux.next = aux2.next;
                aux2 = null;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int i;
        Node aux = head;
        for (i = 0; i < size; i++) {
            if (i == index) {
                return aux.data;
            }
            aux = aux.next;
        }
        return null;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Replaces the element at position index with e, and returns
     *   the element that was replaced.
     *   More formally, it satisfies:
     *     this[index].equals(e) && #this = #old(this) &&
     *     result.equals(old(this)[index]).
     */
    @Override
    public T set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node aux = head;

        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        T dato = aux.data;
        aux.data = e; 
        return dato;

    }

    /**
     * @post inserta a la cabeza
     */
    public void addHead(T e){
        Node aux = new Node(e);
        if (isEmpty()) {
            head = aux;
        } else {
            aux.next = head;
            head = aux;
        }
        size++;
    }

    /**
     * @pre 0 <= index <= size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies:
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    @Override
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addHead(e);
        } else {
            int i;
            Node aux = head;
            Node aux2 = null;
            for (i = 0; i < size; i++) {
                if (i == index) {
                    break;
                }
                aux2 = aux;
                aux = aux.next;
            }
            Node aux3 = new Node(e);
            aux2.next = aux3;
            aux3.next = aux;
            size++;
        }
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies:
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    @Override
    public T remove(int index) {
        if (0 > index || index > size()) {
            throw new IndexOutOfBoundsException("Indice Incorrecto");
        }

        if (isEmpty()) {
            throw new IllegalArgumentException("Lista Vacia");
        }

        T data;
        int i;
        Node aux = head;
        Node aux2 = null;
        
        if (head.next == null) {
            data = head.data;
            head = null;
        }
        
        for (i = 0; i < size; i++) {
            if (i == index || aux.next == null) {
                break;
            }
            aux2 = aux;
            aux = aux.next;
        }

        data = aux.data;
        aux2.next = aux.next;
        aux = null;
        
        return data;
    }

    /**
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies:
     *     result = -1 -> !(e in this) &&
     *     result != -1 -> this[result].equals(e).
     */
    @Override
    public int indexOf(T e) {
        Node aux = head;
        int i = 0;
        while (aux != null) {
            if (aux.data.equals(e)) {
                return i;
            }
            i++;
            aux = aux.next;
        }
        return -1;
    }

    /**
     * @post Returns a string representation of the stack. Implements
     *   the abstraction function. Hence, it represents the stack as a
     *   sequence "[o1, o2,..., on]".
     */
    public String toString() {
        String res = "[";
        boolean first = true;
        for (Node curr = head; curr != null; curr = curr.next) {
            if (!first)
                res += ", ";
            res += curr.data.toString();
            first = false;
        }
        res += "]";
        return res;
    }
}

import java.util.NoSuchElementException;

/**
 * LinkedList is an implementation of the TAD List, based
 * on doubly-linked lists. List represents unbounded
 * sequences of objects of type T.
 *
 * A typical List is a sequence [o1, o2,..., on]; we
 * denote this by: this = [o1, o2,..., on].
 *
 * The methods use equals to determine equality of elements.
 */
public class DoublyLinkedList<T> implements List<T> {

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /**
     * @post Creates an empty List.
     *   More formally, it satisfies: this = [].
     */
    public DoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @post Returns the number of elements in the list.
     *   More formally, it satisfies: result = #this.
     */
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
        Node newNode = new Node(e);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * @post Appends element e to the beginning of this list.
     *   More formally, it satisfies: this = [e] ++ old(this).
     */
    public void addFirst(T e) {
        Node newNode = new Node(e);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * @post Removes all the elements from the list,
     *   More formally, it satisfies: #this = 0.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return getNode(index).data;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the Node at position index
     */
    private Node getNode(int index)
    {
        if( index < 0 || index > size() )
            throw new IndexOutOfBoundsException("Index out of bounds");
        Node p;
        if(index < size() / 2)
        {
            p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        else
        {
            p = tail;
            for (int i = size - 1; i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Replaces the element at position index with e, and returns
     *   the element that was replaced.
     *   More formally, it satisfies:
     *     this[index].equals(e) && #this = #old(this) &&
     *     result.equals(old(this)[index]).
     */
    public T set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node targetNode = getNode(index);
        T oldData = targetNode.data;
        targetNode.data = e;
        return oldData;
    }

    /**
     * @pre 0 <= index <= size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies:
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            add(e);
        } else {
            Node nextNode = getNode(index);
            Node newNode = new Node(e);
            newNode.next = nextNode;
            newNode.prev = nextNode.prev;
            nextNode.prev.next = newNode;
            nextNode.prev = newNode;
            size++;
        }
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

    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies:
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node aux;

        // Caso especial: eliminar el primero
        if (index == 0) {
            aux = head;
            T element = aux.data;

            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // lista vacía
            }

            size--;
            return element;
        }

        // Avanzar hasta el nodo a eliminar
        aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        T element = aux.data;
        if (aux.prev != null) {
            aux.prev.next = aux.next;
        }
        if (aux.next != null) {
            aux.next.prev = aux.prev;
        }
        if (aux == tail) {
            tail = aux.prev;
        }

        size--;
        return element;
    }


    /**
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies:
     *     result = -1 -> !(e in this) &&
     *     result != -1 -> this[result].equals(e).
     */
    public int indexOf(T e) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node aux = head;
        int i = 0;
        while (aux != null) {
            if (aux.data.equals(e)) {
                return i;
            }
            aux = aux.next;
            i++;
        }
        return -1;
    }

    /**
     * @post Removes the first occurrence of e from this list.
     *   If e is not in the list it does not modify the list.
     *   Returns true iff e is removed (result = e in old(list)).
     */
    public boolean remove(T e) {
        Node aux = head;

        while (aux != null) {
            if (aux.data.equals(e)) {
                // Caso: es el primer nodo
                if (aux.prev == null) {
                    head = aux.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null; // la lista quedó vacía
                    }
                }
                // Caso: es el último nodo
                else if (aux.next == null) {
                    tail = aux.prev;
                    tail.next = null;
                }
                // Caso: en el medio
                else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                }

                size--;
                return true;
            }
            aux = aux.next;
        }

        return false;
    }

}

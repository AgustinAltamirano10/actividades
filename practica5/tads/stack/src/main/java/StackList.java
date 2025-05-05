import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackList<T> implements Stack<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public StackList()
    {
        head = null;
        size = 0;
    }

    /**
     * @post Returns the number of elements in the stack.
     *   More formally, it satisfies: result = #this.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @post Returns true iff the stack contains no elements.
     *   More formally, it satisfies: result = (this = []).
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @post Adds element e to the top of the stack.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void push(T e)
    {
        if (head == null) {
            head = new Node(e);
            size++;
        } else {
            Node aux = new Node(e);
            aux.next = head;
            head = aux;
            size++;
        }
    }
    
    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Removes and returns the item at the top of the stack.
     *   More formally, it satisfies: 
     *     let old(this) = s1 ++ [e] |
     *       this = s1 && result = e.
     */
    public T pop()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack vacio");
        }

        T data = head.data;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        return data;
    }

    /**
     * @pre !isEmpty() (throws NoSuchElementException)
     * @post Returns the item at the top of the stack.
     *   More formally, it satisfies:
     *     let this = s1 ++ [e] | result = e.
     */
    public T top()
    {
        return head.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the stack");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }



    /**
     * @post Returns a string representation of the stack. Implements
     *   the abstraction function. Hence, it represents the stack as a 
     *   sequence "[o1, o2,..., on]".
     */
    public String toString()
    {
        String res = "[";
        Node aux = head;
        while (aux != null) {
            if (aux.next == null) {
                res = res + aux.data;
                aux = aux.next;
            } else {
                res = res + aux.data + ", ";
                aux = aux.next;
            }
        }
        res = res + "]";
        return res;
    }
    public static void main(String[] args) {
        StackList<Integer> list = new StackList<>();
        list.push(1);
        list.push(2);
        list.push(2);
        list.push(2);
        list.push(2);
        list.push(2);
        list.push(2);
        System.out.println(list.toString());
        
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {  // Verifica si hay más elementos
            Integer item = it.next();  // Obtiene el siguiente elemento
            System.out.println(item);  // Imprime el elemento
        }
    }

}

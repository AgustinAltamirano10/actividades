import java.util.Arrays;

/**
 * Write a description of class MyArrayList here.
 * 
 */
public class MyArrayList<T> implements List<T> 
{
    private T[] items;
    private static final int MAX_LIST = 100;
    private int numItems;
    /**
     * Constructor for objects of class MyArrayList with specific size.
     */
    public MyArrayList(int size)
    {
        if(size <= 0) {
            throw new IllegalArgumentException("colection size mast be positive");
        }
        items = (T[]) new Object[size];
        numItems = 0;
    }
    
    /**
     * Constructor for objects of class MyArrayList
     */
    public MyArrayList( )
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    }

    /**
     * @post Returns the number of elements in the list.
     *   More formally, it satisfies: result = #this.
     */
    public int size() {
        return numItems;
    }

    /**
     * @post Returns true iff the list contains no elements.
     *   More formally, it satisfies: result = #this = 0.
     */
    public boolean isEmpty() {
        return (numItems==0);
    }
    
    /**
     * @post Returns true iff the list contains element e.
     *   More formally, it satisfies: 
     *   result = exists o | o in this && e.equals(o).
     */
    public boolean contains(T e) {
        int i = 0;
        boolean found = false;
        while(i < numItems && !found) {
            found = e.equals(items[i]);
            i++;
        }    
        return found;
    }
    
    /**
     * @post Appends element e to the end of this list.
     *   More formally, it satisfies: this = old(this) ++ [e].
     */
    public void add(T e) {
        if (numItems == MAX_LIST)
        {
            resize(2*items.length);
        }

        items[numItems] = e;
        numItems++;
        
    }
    
    private void resize(int i) {
        if (i <= size()) {
            throw new IllegalArgumentException("The new array" + "must be larger than  the current size: " + size());
        }
        T[] copy = (T[]) new Object[i];
        for (int j = 0; j < size(); j++) {
            copy[j] = items[i];
        }
        items = copy;
    }

    /**
     * @post Removes the first occurrence of e from this list.
     *   If e is not in the list it does not modify the list.
     *   Returns true iff e is removed (result = e in old(list)).
     */
    public boolean remove(T e) {
        if (numItems == 0) {
            throw new IllegalArgumentException("Lista Vacia");
        }

        for (int i = 0; i <= numItems; i++){
            if (items[i] == e) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * @post Removes all of the elements from the list,
     *   More formally, it satisfies: #this = 0.
     */
    public void clear() {
        numItems = 0;
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Returns the element at position index in the list,
     *   More formally, it satisfies: result = this[index].
     */
    public T get(int index) {
        if (0 > index || index > size() ) {
            throw new IndexOutOfBoundsException("Indice Incorrecto");
        }

        int i = 0;
        boolean found = false;
        while(i < numItems && !found) {
            found = index == i;
            i++;
        } 

        if (index == i - 1) {
            return items[index];
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
    public T set(int index, T e) {
        if (0 > index || index > size() ) {
            throw new IndexOutOfBoundsException("Indice Incorrecto");
        }
        
        T elementoRemplazado; 
        elementoRemplazado = items[index];
        items[index] = e;
        return elementoRemplazado;

    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Inserts the element at position index with e.
     *   More formally, it satisfies: 
     *   this[index].equals(e) && #this = #old(this) +1.
     */
    public void add(int index, T e) {
        if (0 > index || index > size() ) {
            throw new IndexOutOfBoundsException("Indice Incorrecto");
        }

        if (size() == MAX_LIST) {
            resize(2*items.length);
        }

        for (int i = numItems; i >= index; i--) {
            items[i + 1] = items[i];
        }
        items[index] = e;
        numItems++;
    }
    
    /**
     * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
     * @post Removes the element at position index.
     *   More formally, it satisfies: 
     *   result = old(this)[index] && #this = #old(this) -1.
     */
    public T remove(int index) {
        if (0 > index || index > size() ) {
            throw new IndexOutOfBoundsException("Indice Incorrecto");
        }

        T aux = items[index];
        for(int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        numItems--;
        return aux;
    }
    
    /** 
     * @post Returns the index of the first occurrence of e
     *   in the list, or -1 if this list does not contain e.
     *   More formally, it satisfies: 
     *     result = -1 -> !(e in this) && 
     *     result != -1 -> this[result].equals(e).
     */
    public int indexOf(T e) {
        for (int i = 0; i < size(); i++) {
            if (items[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    
    public void show()
    {
        for (int i = 0; i < size(); i++) {
            System.out.println("Elemento " + i + ":" + items[i]);
        }
    }

    public String toString()
    {
        String res = "[";
        for (int i = 0; i < numItems; i++) {
            res += items[i].toString();
            if (i < numItems - 1) {
                res += ", ";
            }
        }
        res += "]";
        return res;
    }


    //main 
    public static void main(String[] args) {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.remove(0);
        System.out.println(lista.toString()); 
    }

    public T[] getItems() {
        return items;
    }

    public void setItems(T[] items) {
        this.items = items;
    }

    public static int getMaxList() {
        return MAX_LIST;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}

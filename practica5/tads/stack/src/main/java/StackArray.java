import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackArray<T> implements Stack<T>  {

    private T[] array;
    private int size;
    private static final int MAX = 100;

    /**
     * @post crea un arreglo vacio
     */
    public StackArray()
    {
        array = (T[]) new Object[MAX];
        size = 0;
    }

    /**
     * @post crea un arreglo vacion pero del tamaño pasado como parametro
     */
    public StackArray(int tamaño)
    {
        array = (T[]) new Object[tamaño];
        size = 0;
    }

    /*
     * @post añade un elemento al tope de la pila
     */
    public void push(T e)
    {
        if (size == MAX) {
            resize(2*array.length);
        }
        size++;
        array[size] = e;
    }

    /**
     * @pre tamaño > size()
     * @post redimensiona el tamaño de la pila
     */
    public void resize (int tamaño)
    {
        if (tamaño < size) {
            throw new IllegalArgumentException("Tamaño incorrecto");
        }
        T[] copy = (T[]) new Object[tamaño];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    /**
     * @post retorna verdaderi la pila esta vacia
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * @pre !isempty()
     * @post remove y retorna el elemento del tope de la pil
     */
    public T pop()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("No hay elementos en la pila");
        }

        T data = array[size - 1];
        array[size - 1] = null;
        size--;

        if (size > 0 && size == array.length/4) {
            resize(array.length/2);
        }
        return data;
    }

    /**
     * @pre !isEmpty()
     * @post retorna el elemento del tope de la pila
     */
    public T top()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("pila vacia");
        }
        return array[size - 1];
    }
    
    /**
     * @post retorna el tamaño de la pila
     */
    public int size()
    {
        return size;
    }

    /**
     * @post
     */
    public String toString()
    {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res = res + array[i];
            if (i < size - 1) {
                res = res + ", ";
            }
        }
        res = res + "]";
        return res;
    }

    /**
     * 
     */
    public boolean repOk()
    {
        if (size < 0 || size > array.length) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext()
            {
                return index < size;
            }

            public T next()
            {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }
}
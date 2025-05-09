package colainvertir;
import java.util.Iterator;

public interface Queue<T> {
    
    public int size();

    public boolean isEmpty();

    public void enqueue( T e);

    public T dequeue();

    public Iterator<T> iterator();

}

package pilainvertir;
import java.util.Iterator;

public interface Stack<T> {
    
    public int size();

    public boolean isEmpty();

    public void push(T e);

    public T pop();

    public T top();

    public Iterator<T> iterator();

    public String toString();
}

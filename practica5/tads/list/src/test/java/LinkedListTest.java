import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
    
    @Test 
    public void testSize()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.size());
        System.out.println("TestSize: " + list.toString());
    }

    @Test
    public void testRemove()
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove("3");
        assertEquals("[1, 2, 4]", list.toString());
        System.out.println("TestRemove: " + list.toString());
    }

    @Test
    public void testGet()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(2, list.get(1));
        System.out.println("TestGet: " + list.toString());
    }

    @Test
    public void testSet()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(4, list.set(3, 999));
        System.out.println("TestSet: " + list.toString());
    }

    @Test
    public void testAdd2()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        list.add(0, 1);
        assertEquals("[1, 1, 2, 3, 4]", list.toString());
        System.out.println("TestAdd2: " + list.toString());
    }

    @Test
    public void testRemove2()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2); // se borra
        list.add(3);
        list.add(4);
        list.remove(1);
        assertEquals("[1, 3, 4]", list.toString());
        System.out.println("TestRemove2: " + list.toString());
    }

    @Test
    public void testIndexOf()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2); // se borra
        list.add(3);
        list.add(4);
        list.add(2);
        assertEquals(1, list.indexOf(2));
        System.out.println("TestIndexOf: " + list.toString());
    }

    // Test Negativos
    @Test
    public void testNegativoGet()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2); 
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class,()-> list.get(200));
    }

    @Test
    public void testNegativoSet()
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2); 
        list.add(3);
        assertThrows(IndexOutOfBoundsException.class,()-> list.set(100, 12));
    }

    @Test
    public void testNegativoAdd()
    {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IndexOutOfBoundsException.class,()-> list.add(1, 40));
    }

    @Test
    public void testNegativoRemove()
    {
        LinkedList<Integer> list = new LinkedList<>();
        assertThrows(IllegalArgumentException.class,()-> list.remove(0));
    }
}

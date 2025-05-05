import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    @Test
    public void testMyArrayList()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.remove(0);
        assertEquals("[2, 3, 4, 5]", lista.toString());
        System.out.println(lista.toString()); 
    }

    @Test 
    public void testContains()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertTrue(lista.contains(2));
        System.out.println(lista.toString()); 
    }

    @Test
    public void testRemove()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.remove(1); // quito el 2
        assertEquals("[1, 3]", lista.toString());
        System.out.println(lista.toString()); 
    }

    @Test
    public void testGet()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        assertEquals(2, lista.get(1));
        System.out.println(lista.toString()); 
    }

    @Test
    public void testSet()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.set(1, 999);
        assertEquals("[1, 999, 3]", lista.toString());
        System.out.println(lista.toString()); 
    }

    @Test
    public void testAdd2()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(0, 0);
        assertEquals("[0, 1, 2, 3]", lista.toString());
        System.out.println(lista.toString()); 
    }

    @Test
    public void testIndexOf()
    {
        MyArrayList<Integer> lista = new MyArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(3);
        lista.add(3);
        lista.add(3);
        lista.add(3);
        lista.add(3);
        lista.add(3);
        assertEquals(2, lista.indexOf(3));
        System.out.println(lista.toString()); 
    }

    // Test Negativos 
    @Test
    public void testNegativoMyarrayList()
    {
        assertThrows(IllegalArgumentException.class,() -> new MyArrayList<>(-1));
    }

    @Test
    public void testNegativoRemove()
    {
        MyArrayList<String> a1 = new MyArrayList<>();
        assertThrows(IllegalArgumentException.class,() -> a1.remove("0"));
    }

    @Test
    public void testNegativoGet()
    {
        MyArrayList<Integer> a1 = new MyArrayList<>();
        a1.add(2);
        a1.add(2);
        a1.add(2);
        assertThrows(IndexOutOfBoundsException.class,() -> a1.get(-1));
    }

    @Test
    public void testNegativoSet()
    {
        MyArrayList<Integer> a1 = new MyArrayList<>();
        a1.add(2);
        a1.add(2);
        a1.add(2);
        assertThrows(IndexOutOfBoundsException.class,() -> a1.set(-5, 5));
    }

    @Test
    public void testNegativoAdd()
    {
        MyArrayList<Integer> a1 = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class,() -> a1.add(20, 3));
    }

}
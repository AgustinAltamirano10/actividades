import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoublyLinkedListTest {

    @Test
    public void testGet0() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.get(0));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testGet1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(20, list.get(1));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testGet2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(30, list.get(2));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexBeginning() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        assertEquals("[10]", list.toString());
    }

    @Test
    public void testAddAtIndexEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 30);
        assertEquals("[10, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexMiddle() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 30);
        list.add(1, 20);
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexBeginningAgain() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(0, 5);
        assertEquals("[5, 10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexEndAgain() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        assertEquals("[10, 20, 30, 40]", list.toString());
    }

    @Test
    public void testRemove() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(2); // se borra el 30
        assertEquals("[10, 20, 40]", list.toString());
        System.out.println(list.toString());
    }

    @Test
    public void testIndexOf() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 20);
        list.add(3, 40);
        assertEquals(1, list.indexOf(20));
        System.out.println(list.toString());
    }

    @Test
    public void testRemove2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(0); // se borra el 10
        assertEquals("[20, 30, 40]", list.toString());
        System.out.println(list.toString());
    }

    @Test
    public void testRemove3() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        assertTrue(list.remove(3) == 40);
        System.out.println(list.toString());
    }

    @Test
    public void testRemove5() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add(0, "10");
        list.add(1, "20");
        list.add(2, "30");
        list.add(3, "40");
        list.remove("30");
        assertEquals("[10, 20, 40]", list.toString());
        System.out.println(list.toString());
    }

    @Test
    public void testRemove100() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.remove(Integer.valueOf(40));
        assertEquals("[10, 20, 30]", list.toString());
        System.out.println(list.toString());
    }

    // Test Negativos
    @Test
    public void testNegativoGet()
    {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.get(40));
    }

    @Test
    public void testNegativoSet()
    {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.set(40, 6));
    }

    @Test
    public void testNegativoAdd()
    {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, ()-> list.add(40, 6));
    }

    @Test
    public void testNegativoRemove()
    {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        assertThrows(IndexOutOfBoundsException.class, ()-> list.remove(-40));
    }
}

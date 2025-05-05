import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class QueueListTest {
    @Test
    void testDequeue() {
        QueueList<Integer> l = new QueueList<>();
        l.enqueue(1);
        l.enqueue(2);
        l.enqueue(3);
        assertEquals(1, l.dequeue());
        System.out.println("TestDequeue: " + l.toString());
    }

    @Test
    void testEnqueue() {
        QueueList<Integer> l = new QueueList<>();
        l.enqueue(1);
        l.enqueue(2);
        l.enqueue(3);
        l.enqueue(4);
        assertEquals("[1, 2, 3, 4]", l.toString());
        System.out.println("TestEnqueue: " + l.toString());
    }

    @Test
    void testIsEmpty() {
        QueueList<Integer> l = new QueueList<>();
        assertTrue(l.isEmpty()); 
        System.out.println("TestIsEmpty: " + l.toString());
    }

    @Test
    void testPalindromoTrue() {
        QueueList<String> l = new QueueList<>();
        l.enqueue("n");
        l.enqueue("e");
        l.enqueue("u");
        l.enqueue("q");
        l.enqueue("u");
        l.enqueue("e");
        l.enqueue("n");
        assertTrue(l.palindromo());
        System.out.println("TestPalindromoTrue: " + l.toString());
    }

    @Test
    void testPalindromoFalse() {
        QueueList<String> l = new QueueList<>();
        l.enqueue("n");
        l.enqueue("e");
        l.enqueue("u");
        l.enqueue("x");
        l.enqueue("u");
        l.enqueue("e");
        l.enqueue("z");
        assertFalse(l.palindromo());
        System.out.println("TestPalindromoFalse: " + l.toString());
    }

    @Test
    void testPeek() {
        QueueList<String> l = new QueueList<>();
        l.enqueue("n");
        l.enqueue("e");
        l.enqueue("u");
        l.enqueue("x");
        assertEquals("n", l.peek());
        System.out.println("TestPeek: " + l.toString());
    }

    @Test
    void testRepOK() {
        QueueList<String> l = new QueueList<>();
        l.enqueue("n");
        l.enqueue("e");
        l.enqueue("u");
        l.enqueue("x");
        assertTrue(l.repOK());
        System.out.println("TestRepOk: " + l.toString());
    }

    @Test
    void testSize() {
        QueueList<String> l = new QueueList<>();
        l.enqueue("n");
        l.enqueue("e");
        l.enqueue("u");
        l.enqueue("x");
        assertEquals(4, l.size());
        System.out.println("TestSize: " + l.toString());
    }

}

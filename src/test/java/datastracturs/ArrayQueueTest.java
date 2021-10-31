package datastracturs;

import datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayQueueTest {
    @Test
    void testEnqueueAndSizeAndIsEmptyWorkCorrectAndChangeTail() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());

        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    void testIsEmptyWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());

        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        System.out.println(arrayQueue.toString());

        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    void testSizeWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertEquals(0, arrayQueue.size());

        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);

        System.out.println(arrayQueue.toString());

        assertEquals(2, arrayQueue.size());
    }

    @Test
    void testContainsWithParameterNullWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);

        assertThrows(NullPointerException.class, () ->  arrayQueue.contains(null));
    }

    @Test
    void testContainsWithExistingParameterWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);

        assertTrue(arrayQueue.contains(2));
    }

    @Test
    void testContainsWithNotExistingParameterWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);
        System.out.println(arrayQueue.toString());

        assertFalse(arrayQueue.contains(3));
    }

    @Test
    void testDequeueWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        assertEquals(2, arrayQueue.dequeue());
        assertEquals(3, arrayQueue.dequeue());
    }

    @Test
    void testThrowIllegalStateExceptionInWhenDequeueOnEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());

        assertEquals(2, arrayQueue.dequeue());
        assertEquals(3, arrayQueue.dequeue());
        assertThrows(IllegalStateException.class, () -> arrayQueue.dequeue());
    }

    @Test
    void testPeekWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.toString());

        assertEquals(3, arrayQueue.peek());
        assertEquals(3, arrayQueue.peek());
    }

    @Test
    void testThrowIllegalStateExceptionInWhenPeekOnEmpty() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertThrows(IllegalStateException.class, () -> arrayQueue.peek());
    }

    @Test
    void testQueueClearWorkCorrect() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        assertEquals(2, arrayQueue.size());
         System.out.println(arrayQueue.toString());
        arrayQueue.clear();
        assertEquals(0, arrayQueue.size());
    }
}

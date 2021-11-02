package datastracturs;

import datastructures.doubleLinkedList.DoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    private DoubleLinkedList doubleLinkedList;


    @BeforeEach
    protected void setUp(){
        doubleLinkedList = new DoubleLinkedList();
    }

    @Test
    public void testEmptyLinkedList(){
        assertTrue(doubleLinkedList.isEmpty());
        assertEquals(0,doubleLinkedList.size());
    }

    @Test
    public void testAddLinkedList(){
        doubleLinkedList.add("A");
        assertFalse(doubleLinkedList.isEmpty());
        assertEquals(1, doubleLinkedList.size());

        doubleLinkedList.add("B");
        assertEquals(2, doubleLinkedList.size());

        doubleLinkedList.add("C");
        assertEquals(3, doubleLinkedList.size());

    }

    @Test
    public void testAddByIndexLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("D", 1);

        assertEquals(3, doubleLinkedList.size());
    }

    @Test
    public void testGetLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertEquals("B", doubleLinkedList.get(1));
    }

    @Test
    public void testAddByIndexThrowExceptionThenIndexBiggerThenSizeLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.add("C",4));
    }

    @Test
    public void testGetThrowExceptionThenIndexBiggerThenSizeLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.get(4));
    }

    @Test
    public void testRemoveLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertEquals("B",   doubleLinkedList.remove(1));
        assertEquals("A",   doubleLinkedList.remove(0));
        assertTrue(doubleLinkedList.isEmpty());
    }

    @Test
    public void testRemoveThrowExceptionThenIndexBiggerThenSizeLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.remove(4));
    }

    @Test
    public void testClearLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertFalse(doubleLinkedList.isEmpty());

        doubleLinkedList.clear();

        assertTrue(doubleLinkedList.isEmpty());

    }

    @Test
    public void testIndexOfLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertEquals(0,doubleLinkedList.indexOf("A"));
        assertEquals(1,doubleLinkedList.indexOf("B"));
    }


    @Test
    public void testLastIndexOfLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertEquals(3,doubleLinkedList.lastIndexOf("A"));
        assertEquals(2,doubleLinkedList.lastIndexOf("C"));
    }


    @Test
    public void testLastIndexOfNotFoundLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertEquals(-1,doubleLinkedList.lastIndexOf("D"));
    }

    @Test
    public void testContainsNotFoundLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertFalse(doubleLinkedList.contains("D"));
    }

    @Test
    public void testContainsLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertTrue(doubleLinkedList.contains("A"));
        assertTrue(doubleLinkedList.contains("B"));
        assertTrue(doubleLinkedList.contains("C"));
    }

    @Test
    public void testSetLinkedList(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertEquals("D",doubleLinkedList.set("D", 1));
        assertEquals("E",doubleLinkedList.set("E", 0));
    }


}

package datastracturs;

import datastructures.doubleLinkedList.DoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    private DoubleLinkedList<String> doubleLinkedList;


    @BeforeEach
    protected void setUp(){
        doubleLinkedList = new DoubleLinkedList<String>();
    }

    @Test
    public void testisEmpty(){
        assertTrue(doubleLinkedList.isEmpty());
        assertEquals(0,doubleLinkedList.size());
    }

    @Test
    public void testAddValueInTheEnd(){
        doubleLinkedList.add("A");
        assertFalse(doubleLinkedList.isEmpty());
        assertEquals(1, doubleLinkedList.size());

        doubleLinkedList.add("B");
        assertEquals(2, doubleLinkedList.size());

        doubleLinkedList.add("C");
        assertEquals(3, doubleLinkedList.size());

    }

    @Test
    public void testToString(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        String currentValueString = "[ A, B, C ]";

        assertEquals(3, doubleLinkedList.size());
        assertEquals(currentValueString, doubleLinkedList.toString());
    }

    @Test
    public void testAddValueInTheHead(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D",0);

        assertEquals(4, doubleLinkedList.size());
        String currentValueString = "[ D, A, B, C ]";
        assertEquals(currentValueString, doubleLinkedList.toString());
    }

    @Test
    public void testAddValueInTheTail(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D",doubleLinkedList.size());

        assertEquals(4, doubleLinkedList.size());
        String currentValueString = "[ A, B, C, D ]";
        assertEquals(currentValueString, doubleLinkedList.toString());
    }

    @Test
    public void testAddValueInTheMiddle(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D", 1);
        System.out.println(doubleLinkedList.toString());
        assertEquals(4, doubleLinkedList.size());
        String currentValueString = "[ A, D, B, C ]";
        assertEquals(currentValueString, doubleLinkedList.toString());
    }

    @Test
    public void testAddByIndexThrowExceptionThenIndexBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IndexOutOfBoundsException.class,   () -> doubleLinkedList.add("C",4));
    }

    @Test
    public void testAddByIndexThrowExceptionThenIndexIsNegativeBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IndexOutOfBoundsException.class,   () -> doubleLinkedList.add("C",-1));
    }

    @Test
    public void testAddByIndexThrowExceptionThenValueISNull(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.add(null,1));
    }

    @Test
    public void testGetByIndexFromHead(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");

        assertEquals("B", doubleLinkedList.get(1));
    }

    @Test
    public void testGetByIndexFromTail(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");

        assertEquals("D", doubleLinkedList.get(3));
    }

    @Test
    public void testGetThrowExceptionThenIndexBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.get(4));
    }

    @Test
    public void testGetThrowExceptionThenIndexIsNegativeBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.get(-1));
    }

    @Test
    public void testGetThrowExceptionThenIndexEqualsSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.get(2));
    }

    @Test
    public void testRemoveFromHead(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertEquals("A",   doubleLinkedList.remove(0));
    }

    @Test
    public void testRemoveFromTail(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");

        assertEquals("C",   doubleLinkedList.remove(2));
    }

    @Test
    public void testRemoveFromMiddle(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("D");

        assertEquals("B",   doubleLinkedList.remove(1));
    }

    @Test
    public void testRemoveThrowExceptionThenIndexBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.remove(4));
    }

    @Test
    public void testRemoveThrowExceptionThenIndexEqualsSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.remove(2));
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
        doubleLinkedList.add("C");
        doubleLinkedList.add("B");

        assertEquals(0,doubleLinkedList.indexOf("A"));
        assertEquals(1,doubleLinkedList.indexOf("B"));
    }

    @Test
    public void testIndexOfNotFound(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("B");

        assertEquals(-1,doubleLinkedList.indexOf("S"));
    }

    @Test
    public void testIndexOfThrowExceptionThenListIsEmpty(){
        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.indexOf("A"));
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
    public void testLastIndexOfThrowExceptionThenListIsEmpty(){
        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.lastIndexOf("A"));
    }

    @Test
    public void testContainsNotFound(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertFalse(doubleLinkedList.contains("D"));
    }

    @Test
    public void testContains(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertTrue(doubleLinkedList.contains("A"));
        assertTrue(doubleLinkedList.contains("B"));
        assertTrue(doubleLinkedList.contains("C"));
    }

    @Test
    public void testSet(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");
        doubleLinkedList.add("C");
        doubleLinkedList.add("A");

        assertEquals("D",doubleLinkedList.set("D", 1));
        assertEquals("E",doubleLinkedList.set("E", 0));

        String currentValueString = "[ E, D, C, A ]";
        assertEquals(currentValueString, doubleLinkedList.toString());
    }

    @Test
    public void testSetThrowExceptionThenIndexBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.set("D",4));
    }

    @Test
    public void testSetThrowExceptionThenIndexIsNegativeBiggerThenSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.set("D",-1));
    }

    @Test
    public void testSetThrowExceptionThenIndexEqualsSize(){
        doubleLinkedList.add("A");
        doubleLinkedList.add("B");

        assertThrows(IllegalStateException.class,   () -> doubleLinkedList.set(null,2));
    }
}

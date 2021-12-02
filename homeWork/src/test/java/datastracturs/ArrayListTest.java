package datastracturs;

import datastructures.list.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {

    private ArrayList arrayList;


    @BeforeEach
    protected void setUp(){
        arrayList = new ArrayList();
    }

    @Test
    public void testisEmpty(){
        assertTrue(arrayList.isEmpty());
        assertEquals(0,arrayList.size());
    }

    @Test
    public void testAddValueInTheEnd(){
        arrayList.add("A");
        assertFalse(arrayList.isEmpty());
        assertEquals(1, arrayList.size());

        arrayList.add("B");
        assertEquals(2, arrayList.size());

        arrayList.add("C");
        assertEquals(3, arrayList.size());

    }

    @Test
    public void testToString(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        String currentValueString = "[ A, B, C ]";

        assertEquals(3, arrayList.size());
        assertEquals(currentValueString, arrayList.toString());
    }

    @Test
    public void testAddValueInTheHead(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D",0);

        assertEquals(4, arrayList.size());
        String currentValueString = "[ D, A, B, C ]";
        assertEquals(currentValueString, arrayList.toString());
    }

    @Test
    public void testAddValueInTheTail(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D",arrayList.size());

        assertEquals(4, arrayList.size());
        String currentValueString = "[ A, B, C, D ]";
        assertEquals(currentValueString, arrayList.toString());
    }

    @Test
    public void testAddValueInTheMiddle(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D", 1);

        assertEquals(4, arrayList.size());
        String currentValueString = "[ A, D, B, C ]";
        assertEquals(currentValueString, arrayList.toString());
    }

    @Test
    public void testAddByIndexThrowExceptionThenIndexBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IndexOutOfBoundsException.class,   () -> arrayList.add("C",4));
    }

    @Test
    public void testAddByIndexThrowExceptionThenIndexIsNegativeBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IndexOutOfBoundsException.class,   () -> arrayList.add("C",-1));
    }

    @Test
    public void testAddByIndexThrowExceptionThenValueISNull(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IllegalStateException.class,   () -> arrayList.add(null,1));
    }

    @Test
    public void testGetByIndexFromHead(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals("B", arrayList.get(1));
    }

    @Test
    public void testGetByIndexFromTail(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals("D", arrayList.get(3));
    }

    @Test
    public void testGetThrowExceptionThenIndexBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IllegalStateException.class,   () -> arrayList.get(4));
    }

    @Test
    public void testGetThrowExceptionThenIndexIsNegativeBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IllegalStateException.class,   () -> arrayList.get(-1));
    }

    @Test
    public void testGetThrowExceptionThenIndexEqualsSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IllegalStateException.class,   () -> arrayList.get(2));
    }

    @Test
    public void testRemoveFromHead(){
        arrayList.add("A");
        arrayList.add("B");

        assertEquals("A",   arrayList.remove(0));
    }

    @Test
    public void testRemoveFromTail(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertEquals("C",   arrayList.remove(2));
    }

    @Test
    public void testRemoveFromMiddle(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals("B",   arrayList.remove(1));
    }

    @Test
    public void testRemoveThrowExceptionThenIndexBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IllegalStateException.class,   () -> arrayList.remove(4));
    }

    @Test
    public void testRemoveThrowExceptionThenIndexEqualsSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IllegalStateException.class,   () -> arrayList.remove(2));
    }

    @Test
    public void testClearLinkedList(){
        arrayList.add("A");
        arrayList.add("B");

        assertFalse(arrayList.isEmpty());

        arrayList.clear();

        assertTrue(arrayList.isEmpty());

    }

    @Test
    public void testIndexOfLinkedList(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("B");

        assertEquals(0,arrayList.indexOf("A"));
        assertEquals(1,arrayList.indexOf("B"));
    }

    @Test
    public void testIndexOfNotFound(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("B");

        assertEquals(-1,arrayList.indexOf("S"));
    }

    @Test
    public void testIndexOfThrowExceptionThenListIsEmpty(){
        assertThrows(IllegalStateException.class,   () -> arrayList.indexOf("A"));
    }


    @Test
    public void testLastIndexOfLinkedList(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertEquals(3,arrayList.lastIndexOf("A"));
        assertEquals(2,arrayList.lastIndexOf("C"));
    }


    @Test
    public void testLastIndexOfNotFoundLinkedList(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertEquals(-1,arrayList.lastIndexOf("D"));
    }

    @Test
    public void testLastIndexOfThrowExceptionThenListIsEmpty(){
        assertThrows(IllegalStateException.class,   () -> arrayList.lastIndexOf("A"));
    }

    @Test
    public void testContainsNotFound(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertFalse(arrayList.contains("D"));
    }

    @Test
    public void testContains(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertTrue(arrayList.contains("A"));
        assertTrue(arrayList.contains("B"));
        assertTrue(arrayList.contains("C"));
    }

    @Test
    public void testSet(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("A");

        assertEquals("D",arrayList.set("D", 1));
        assertEquals("E",arrayList.set("E", 0));

        String currentValueString = "[ E, D, C, A ]";
        assertEquals(currentValueString, arrayList.toString());
    }

    @Test
    public void testSetThrowExceptionThenIndexBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IndexOutOfBoundsException.class,   () -> arrayList.set("D",4));
    }

    @Test
    public void testSetThrowExceptionThenIndexIsNegativeBiggerThenSize(){
        arrayList.add("A");
        arrayList.add("B");

        assertThrows(IndexOutOfBoundsException.class,   () -> arrayList.set("D",-1));
    }

    @Test
    public void testSetThrowExceptionThenIndexEqualsSize(){
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");

        assertThrows(IllegalStateException.class,   () -> arrayList.set(null,2));
    }
}

package datastracturs;

import datastructures.list.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {
    @Test
    void testAddWorkCorrectAndChangeSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        assertEquals(1, arrayList.size());

        arrayList.add(2);
        assertEquals(2, arrayList.size());
    }

    @Test
    void testGetWorkCorrect(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertEquals(2,         arrayList.get(1));
    }

    @Test
    void testIndexOutOfBoundsExceptionInWhenGetIsBiggerThenSize(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertThrows(IndexOutOfBoundsException.class,()-> arrayList.get(3));
    }

    @Test
    void testIndexOfWorkCorrectWithExistingParameter(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertEquals(1,arrayList.indexOf(2));
    }

    @Test
    void testIndexOfWorkCorrectWithNotExistingParameter(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertEquals(-1,arrayList.indexOf(3));
    }

    @Test
    void testContainsWorkCorrectWithNotExistingParameter(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertFalse(arrayList.contains(3));
    }

    @Test
    void testContainsWorkCorrectWithExistingParameter(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertTrue(arrayList.contains(2));
    }

    @Test
    void testisEmptyWorkCorrect(){
        ArrayList arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());

        arrayList.add(1);
        arrayList.add(2);

        assertFalse(arrayList.isEmpty());
    }

    @Test
    void testisLastIndexOfCorrectExistingParameter(){
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);

        assertEquals(2,arrayList.lastIndexOf(1));
    }

    @Test
    void testisLastIndexOfCorrectNotExistingParameter(){
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);

        assertEquals(-1, arrayList.lastIndexOf(3));
    }

    @Test
    void testRemoveCorrect(){
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);

        assertEquals(2, arrayList.remove(1));
    }

    @Test
    void testThrowsIndexOutOfBoundsExceptionOnRemoveIndexThenSize(){
        ArrayList arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.remove(3));
    }

    @Test
    void testClearWorkCorrect(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        assertEquals(3,arrayList.size());
        arrayList.clear();
        assertEquals(0,arrayList.size());
    }

    @Test
    void testSetWorkCorrect(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);

        arrayList.set(2,2);

        assertEquals(2,arrayList.get(2));
    }
}

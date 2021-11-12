package datastructures.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    public ArrayList() {
        this(20);
    }

    private void increaseCapacityIfNeed() {
        if (array.length == size) {
            int newSize = (int) (size * 1.5);
            Object[] arrayNew = new Object[ newSize];

            System.arraycopy(array, 0, arrayNew, 0, size);
            size = newSize;
            array = arrayNew;
        }
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }  else if (value == null) {
            throw new IllegalStateException();
        }

        increaseCapacityIfNeed();
        Object[] newArray = new Object[array.length];
        int count = 0;

        for (int i = 0; i < size + 1; i++) {
            if (i == index) {
                newArray[count] = value;
                count++;
            }

            newArray[count] = array[i];
            count++;
        }
        array = newArray;
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index >= size) {
            throw new  IllegalStateException("Index " + index+" out of bounds size ArrayList " + size);
        }
        Object removedValue = array[index];
        Object[] newArray = new Object[size - 1];
        int count = 0;

        for (int i = 0; i < size - 1; i++) {
            if (index != i){
                newArray[count] = array[i];
                count++;
            }
        }
        size--;
        return removedValue;
    }

    @Override
    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new  IllegalStateException("Index " + index+" out of bounds size ArrayList " + size);
        }

        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if (index >= size || index < 0) {
            throw new  IndexOutOfBoundsException("Index " + index+" out of bounds size ArrayList " + size);
        } else if (value == null) {
            throw new IllegalStateException();
        }

        increaseCapacityIfNeed();
        return array[index] = value;
    }

    @Override
    public void clear() {
        array = new Object[array.length];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        if (value == null || isEmpty()) {
            throw new IllegalStateException();
        }

        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        if (value == null || isEmpty()) {
            throw new IllegalStateException();
        }

        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        Iterator<Object> iterable = iterable();

        while (iterable.hasNext()){
            stringJoiner.add(iterable.next().toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<Object> iterable() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<Object> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex != size;
        }

        @Override
        public Object next() {
            Object currentObject = get(currentIndex);
            currentIndex++;
            return currentObject;
        }
    }
}

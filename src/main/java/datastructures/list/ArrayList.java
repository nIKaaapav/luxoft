package datastructures.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {
    private T[] array;
    private int size;

    public ArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public ArrayList() {
        this(20);
    }

    private void increaseCapacityIfNeed() {
        if (array.length == size) {
            int newSize = (int) (size * 1.5);
            T[] arrayNew = (T[]) new Object[ newSize];

            System.arraycopy(array, 0, arrayNew, 0, size);
            size = newSize;
            array = arrayNew;
        }
    }

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }  else if (value == null) {
            throw new IllegalStateException();
        }

        increaseCapacityIfNeed();
        T[] newArray = (T[]) new Object[array.length];
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
    public T remove(int index) {
        if (index >= size) {
            throw new  IllegalStateException("Index " + index+" out of bounds size ArrayList " + size);
        }
        T removedValue = array[index];
        T[] newArray = (T[]) new Object[size - 1];
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
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new  IllegalStateException("Index " + index+" out of bounds size ArrayList " + size);
        }

        return array[index];
    }

    @Override
    public T set(T value, int index) {
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
        array = (T[]) new Object[array.length];
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
        Iterator<T> iterable = iterable();

        while (iterable.hasNext()){
            stringJoiner.add(iterable.next().toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterable() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex != size;
        }

        @Override
        public T next() {
            T currentObject = get(currentIndex);
            currentIndex++;
            return currentObject;
        }
    }
}

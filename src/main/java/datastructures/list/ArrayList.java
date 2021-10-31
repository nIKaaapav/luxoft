package datastructures.list;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList(int size) {
        this.array = new Object[size];
    }

    public ArrayList() {
        this.array = new Object[16];
    }

    private void increaseSize() {
        if (array.length == size) {
            int newSize = size * 2;
            Object[] arrayNew = new Object[newSize];

            System.arraycopy(array, 0, arrayNew, 0, size);
            size = newSize;
            array = arrayNew;
        }
    }

    @Override
    public void add(Object value) {
        increaseSize();
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if(index > size){
            increaseSize();
        }

        array[index] = value;
    }

    @Override
    public Object remove(int index) {
        if (index >= size) {
            throw new  IndexOutOfBoundsException("Index " + index+" out of bounds size ArrayList " + size);
        }
        Object removedValue = array[index];
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
        return removedValue;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new  IndexOutOfBoundsException("Index " + index+" out of bounds size ArrayList " + size);
        }

        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        increaseSize();
        return array[index] = value;
    }

    @Override
    public void clear() {
        array = new Object[16];
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
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
}

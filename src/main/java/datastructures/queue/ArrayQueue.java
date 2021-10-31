package datastructures.queue;

import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayQueue implements Queue {
    Object[] array;
     int head  = 0;
     int tail = 0;

    public ArrayQueue(int size) {
        if (size >= 0 ){
            array = new Object[size];
        } else throw new IllegalArgumentException("This size dont valid");
    }

    public ArrayQueue() {
        array = new Object[16];
    }

    private void increaseSize () {
        if (array.length == tail) {
            Object[] arrayNew = new Object[head * 2];
            int  k = 0;
            for (int i = head; i < tail; i++) {
                arrayNew[k] = array[i];
                k++;
            }
            head = 0;
            tail = k;
            array = arrayNew;
        }
    }

    @Override
    public void enqueue(Object value) {
        if (value == null) {
            throw new NullPointerException("this value is illegal");
        }
        if (array.length == tail) {
            increaseSize();
        }
        array[head++] = value;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return array[tail++];
    }

    @Override
    public Object peek() {
        if (isEmpty()){
          throw new IllegalStateException("Queue is empty");
        }
        return array[head - 1];
    }

    @Override
    public int size() {
        return head - tail;
    }

    @Override
    public boolean isEmpty() {
        return head <= tail;
    }

    @Override
    public boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException("this value is illegal");
        }

        for (int i = tail; i < head; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[0];
        tail = 0;
        head = 0;
    }

    @Override
    public String toString() {
        StringJoiner s = new StringJoiner(", ", "[ ", " ]");

        for (int i = tail; i < head; i++) {
            s.add(array[i].toString());
        }
        return s.toString();
    }
}

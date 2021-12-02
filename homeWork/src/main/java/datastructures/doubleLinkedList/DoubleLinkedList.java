package datastructures.doubleLinkedList;

import datastructures.list.List;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoubleLinkedList<T> implements List<T> {
    Node head;
    Node tail;
    int size;

    @Override
    public void add(T value, int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }  else if (value == null) {
            throw new IllegalStateException();
        }

        Node newNode = new Node(value);

        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }else if (index == size) {
            System.out.println(index);
            Node tailCurrent = this.tail;
            tailCurrent.next = newNode;
            newNode.prev = tailCurrent;
            System.out.println(newNode.prev.value);
            tail = newNode;
            System.out.println(tail.value);
            size++;
            return;
        }else if (index == 0) {
            Node nextCurrentNode = head;
            head = newNode;
            head.next = nextCurrentNode;
            nextCurrentNode.prev = head;

            size++;
            return;
        } else {
            Node node = getNode(index);
            Node prev = node.prev;
            node.prev = newNode;
            newNode.next = node;
            prev.next = newNode;
            newNode.prev = prev;
            size++;
        }
    }

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public T remove(int index) {
        if (index > size - 1) {
            throw new IllegalStateException();
        } if (index < 0) {
            throw new IllegalStateException();
        }

        Node<T> currentNode = head;
        Node<T> nextNode = head.next;

        if (index == 0){
            head = nextNode;
            size--;
            return currentNode.value;
        } else if(index == size - 1){
            Node<T> currentRemovedNode = tail;
            tail = tail.prev;
            size--;
            return currentRemovedNode.value;
        } if (size == 1){
            head = tail = null;
            size--;
            return currentNode.value;
        } else {
            Node<T> node = getNode(index);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
            return node.value;
        }
    }

    private Node<T> getNodeFromTail(int index, Node node){
        if (node == null) return null;
        if (index == 0) return node;
        return getNodeFromTail(index-1, node.prev);
    }

    private Node<T> getNodeFromHead(int index, Node node){
        if (node == null) return null;
        if (index == 0) return node;
        return getNodeFromHead(index-1, node.next);
    }

    private Node<T> getNode(int index) {
        if (index > size - 1) {
            throw new IllegalStateException();
        } else if (index < 0) {
            throw new IllegalStateException();
        }
        return index > size / 2  ?  getNodeFromTail(size - 1 - index, tail) : getNodeFromHead(index, head);
    }

    @Override
    public T get(int index) {
       return getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        Node<T> o = getNode(index);
        o.value = value;
        return o.value;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    private int indexOf(T value, Node node, int index) {
        if (node == null) return -1;
        if (Objects.equals(node.value, value)) return index;
        return indexOf(value, node.next, index+1);
    }

    @Override
    public int indexOf(T value) {
        if (isEmpty()){
            throw new IllegalStateException();
        }

        Node currentNode = head;
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(value, currentNode.value)){
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    private int lastIndexOf(T value, Node node, int index) {
        if (node == null) return -1;
        if (Objects.equals(node.value, value)) return index;
        return lastIndexOf(value, node.prev, index - 1);
    }

    @Override
    public int lastIndexOf(T value) {
        if (isEmpty()){
            throw new IllegalStateException();
        }

        Node currentNode = tail;

        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(value, currentNode.value)){
                return size - 1 - i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    private String toString(StringJoiner stringJoiner, Node node) {
        if (node == null) return stringJoiner.toString();
        stringJoiner.add(node.value.toString());
        return toString(stringJoiner, node.next);
    }

    private static class Node<T> {
        private Node next;
        private Node prev;
        private T value;

        private Node(T value) {
            this.value = value;
        }
    }



    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[ ", " ]");
        Node<T> curr = head;

        Iterator<T> iterable = iterable();
        while (iterable.hasNext()){
            stringJoiner.add(iterable.next().toString());
        }
        return stringJoiner.toString();

    }

    @Override
    public Iterator<T> iterable() {
        return new DoubleLinkedListIterator();
    }


    private class DoubleLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T currentObject = current.value;
            current = current.next;
            return currentObject;
        }

        @Override
        public void remove() {
        }
    }


}

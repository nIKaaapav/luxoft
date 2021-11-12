package datastructures.doubleLinkedList;

import datastructures.list.List;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class DoubleLinkedList implements List {
    Node head;
    Node tail;
    int size;

    private void addFromTail(int index, Node newNode){
        int currentIndex = size - index;
        Node currentNode = tail;

        for (int i = 0; i < size; i++) {
            if (currentIndex == i){
                Node nextNodeBeforeAdd = currentNode.next;

                currentNode.next = newNode;
                if (nextNodeBeforeAdd != null) {
                    nextNodeBeforeAdd.prev = newNode;
                }
                newNode.next = nextNodeBeforeAdd;
                newNode.prev = currentNode;
                size ++;
                return;
            }
            currentNode = currentNode.prev;
        }
    }

    private void addFromHead(int index, Node newNode){
        int currentIndex = index;
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (currentIndex - 1 == i){
                Node nextNodeBeforeAdd = current.next;

                current.next = newNode;
                if (nextNodeBeforeAdd != null) {
                    nextNodeBeforeAdd.prev = newNode;
                }
                newNode.next = nextNodeBeforeAdd;
                newNode.prev = current;
                size ++;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public void add(Object value, int index) {
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
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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
            if (index >= (size - 1) / 2){
                addFromTail(index, newNode);
            } else if (index < (size - 1) / 2) {
                addFromHead(index, newNode);
            }
        }
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public Object remove(int index) {
        if (index > size - 1) {
            throw new IllegalStateException();
        } if (index < 0) {
            throw new IllegalStateException();
        }

        Node currentNode = head;
        Node nextNode = head.next;
        Node previousNode = null;

        if (index == 0){
            head = nextNode;
            return currentNode.value;
        } else if(index == size - 1){
            Node currentRemovedNode = tail;
            tail = tail.prev;
            return currentRemovedNode.value;
        } if (size == 1){
            head = tail = null;
            return currentNode.value;
        }

        while (currentNode != null) {
            if (index == 0){
                previousNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = previousNode;
                }
                return currentNode.value;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
            index--;
        }
        return null;
    }

    private Node getNodeFromTail(int index, Node node){
        if (node == null) return null;
        if (index == 0) return node;
        return getNodeFromTail(index-1, node.prev);
    }

    private Node getNodeFromHead(int index, Node node){
        if (node == null) return null;
        if (index == 0) return node;
        return getNodeFromHead(index-1, node.next);
    }

    private Node getNode(int index) {
        if (index > size - 1) {
            throw new IllegalStateException();
        } else if (index < 0) {
            throw new IllegalStateException();
        }
        return index > size / 2  ?  getNodeFromTail(size - 1 - index, tail) : getNodeFromHead(index, head);
    }

    @Override
    public Object get(int index) {
       return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        Node o = getNode(index);
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
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    private int indexOf(Object value, Node node, int index) {
        if (node == null) return -1;
        if (Objects.equals(node.value, value)) return index;
        return indexOf(value, node.next, index+1);
    }

    @Override
    public int indexOf(Object value) {
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

    private int lastIndexOf(Object value, Node node, int index) {
        if (node == null) return -1;
        if (Objects.equals(node.value, value)) return index;
        return lastIndexOf(value, node.prev, index - 1);
    }

    @Override
    public int lastIndexOf(Object value) {
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

    private static class Node {
        Node next;
        Node prev;
        Object value;

        private Node(Object value) {
            this.value = value;
        }
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
        return new DoubleLinkedListIterator();
    }


    private class DoubleLinkedListIterator implements Iterator<Object> {
        private Node current = head;


        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Object next() {
            Object currentObject = current.value;
            current = current.next;
            return currentObject;
        }

        @Override
        public void remove() {
        }
    }


}

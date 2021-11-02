package datastructures.doubleLinkedList;

import datastructures.list.List;

import java.util.Objects;
import java.util.StringJoiner;

public class DoubleLinkedList implements List {
    class Node {
        Node next;
        Node prev;
        Object value;

        public Node(Object value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size;

    @Override
    public void add(Object value, int index) {
        if (index > size) throw new IllegalStateException();
        if (index == size) add(value);

        Node newNode = new Node(value);
        if (index == 0) {
            Node nextCurrentNode = head.next;
            nextCurrentNode.prev = newNode;
            head = newNode;

            size += 1;
        } else {
            Node current = head;
            int currentSize = 0;

            while (current != null) {
                if (index  - 1 == currentSize) {
                    Node nextNodeBrforeAdd = current.next;
                    if (nextNodeBrforeAdd != null) nextNodeBrforeAdd.prev = newNode;
                    newNode.next = current.next;
                    current.next = newNode;
                    size += 1;
                    if (index == size) tail = newNode;
                    return;
                }
                currentSize++;
                current = current.next;
            }

        }
    }

    @Override
    public void add(Object value) {
        Node nodeNew = new Node(value);
        if (size == 0) {
            head = tail = nodeNew;
            head.next = tail;
        } else  {
            tail.next = nodeNew;
            nodeNew.prev = tail;
            tail = nodeNew;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index > size) throw new IllegalStateException();

        Node currentNode = head;
        Node nextNode = head.next;
        Node previousNode = null;

        while (currentNode != null) {
            if (index == 0){
                if (previousNode == null) {
                    head = nextNode;
                    return currentNode.value;
                }
                previousNode.next = nextNode;
                if (nextNode != null) nextNode.prev = previousNode;
                return currentNode.value;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
            index--;
        }
        return null;
    }

    private Object getFromTail(int index, Node node){
        if (node == null) return null;
        if (index == 0) return node.value;
        return getFromTail(index-1, node.prev);
    }

    private Object getFromHead(int index, Node node){
        if (node == null) return null;
        if (index == 0) return node.value;
        return getFromHead(index-1, node.next);
    }

    @Override
    public Object get(int index) {
        if (index > size) throw new IllegalStateException();
        return index > size / 2  ?  getFromTail(size - index, tail) : getFromHead(index, head);
    }

    private Object setFromHead(Object value, int index,Node node) {
        if (node == null) return null;
        if (index == 0) {
            node.value = value;
            return node.value;
        }
        return setFromHead(value, index-1, node.next);
    }

    private Object setFromTail(Object value, int index,Node node) {
        if (node == null) return null;
        if (index == 0) {
            node.value = value;
            return node.value;
        }
        return setFromTail(value, index-1, node.prev);
    }

    @Override
    public Object set(Object value, int index) {
        return index > size / 2  ?  setFromTail(value, index, tail) : setFromHead(value, index, head);
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private int size(Node node, int size) {
        System.out.printf("size = %s \n", size);
        if (node == null) return size;
        System.out.printf("value = %s \n", node.value);
        return size(node.next, size + 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private boolean contains(Object value, Node node) {
        if (node == null) return false;
        if (Objects.equals(node.value, value)) return true;
        return contains(value, node.next);
    }

    @Override
    public boolean contains(Object value) {
        return contains(value, head);
    }

    private int indexOf(Object value, Node node, int index) {
        if (node == null) return -1;
        if (Objects.equals(node.value, value)) return index;
        return indexOf(value, node.next, index+1);
    }

    @Override
    public int indexOf(Object value) {
        return indexOf(value, head, 0);
    }

    private int lastIndexOf(Object value, Node node, int index) {
        if (node == null) return -1;
        if (Objects.equals(node.value, value)) return index;
        return indexOf(value, node.prev, index - 1);
    }

    @Override
    public int lastIndexOf(Object value) {
        return lastIndexOf(value, tail, size - 1);
    }

    private String toString(StringJoiner stringJoiner, Node node) {
        if (node == null) return stringJoiner.toString();
        stringJoiner.add(node.value.toString());
        return toString(stringJoiner, node.next);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" ,", "[ ", " ]");
        return toString(stringJoiner, head);
    }
}

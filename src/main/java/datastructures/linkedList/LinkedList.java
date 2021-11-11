package datastructures.linkedList;

import datastructures.list.List;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList implements List {
    class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;

    public void addHead(Object value){
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void addItarable(Object value) {
        Node item = new Node(value);
        if (head == null) {
            head = item;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = item;
        }
    }

    private Node addTail_2(Object value,Node node){
        if (node == null) {
            Node node1 = new Node(value);
            return node1;
        }
        node.next = addTail_2(value, node.next);
        return node;
    }

    public void addTail(Object value){
        head = addTail_2(value, head);
    }

    @Override
    public void add(Object value) {
        addTail(value);
    }

    public void addRecurse_2(Node node, Object value, int index) {
        if (node == null) return;
        if (index == 0) node.value = value;
        addRecurse_2(node.next, value,index - 1);
    }

    @Override
    public void add(Object value, int index) {
        addRecurse_2(head, value, index);
    }

    public Object getIterable(int index) {
        int indexCurrent = 0;
        Node currentNode = head;
        while (currentNode != null) {
            if (index == indexCurrent)  return currentNode.value;
            indexCurrent++;
            currentNode = currentNode.next;
        }
        throw new IndexOutOfBoundsException(
                String.format("Index %d is out of range %d", index, indexCurrent)
        );
    }

    public Object getRecurse_1(int index, Node node) {
        if (node == null) return -1; // or null / Exception / Optional
        if (index == 0) return  node.value;
        return getRecurse_1(index - 1, node.next);
    }

    public Object getRecurse(int index) {
        return getRecurse_1(index, head);
    }


    @Override
    public Object get(int index) {
        return getRecurse(index);
    }

    @Override
    public void clear() {
        head = null;
    }

    public int sizeIterable() {
        int size = 0;
        Node currentNode = head;
        while (currentNode != null){
            size ++;
        }
        return size;
    }

    private int sizeRecurse_2(int size, Node node) {
        if (node == null) return size;
        else return sizeRecurse_2(size++, node.next);
    }

    public int sizeRecurse() {
       return sizeRecurse_2(0, head);
    }

    private int sizeTailRecurse_2(Node node) {
        if (node == null) return 0;
        int size = sizeTailRecurse_2(node.next);
        return size + 1;
    }

    public int sizeTailRecurse() {
       return sizeTailRecurse_2(head);
    }


    @Override
    public int size() {
        return sizeTailRecurse();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private boolean containsIterable(Object value) {
        Node currentNode = head;
        while (!currentNode.value.equals(value)) {
            if (currentNode.value.equals(value)) return true;
            currentNode = currentNode.next;
        }
        return false;
    }

    private boolean containsRecurse(Object value, Node node) {
        if (node == null) return false;
        if(node.value.equals(value)) return true;
        else return containsRecurse(value, node.next);
    }

    @Override
    public boolean contains(Object value) {
        return containsRecurse(value, head);
    }

    @Override
    public Object remove(int index) {
       Node currentNode = head;
       Node previousNode = null;
       int currentSize = 0;
       while (currentNode != null) {
           if (currentSize == index){
              if(previousNode == null) {
                  head = head.next;
                  return head;
              }
              previousNode.next = currentNode.next;
              return currentNode;
           }
           currentSize++;
           previousNode = currentNode;
           currentNode = currentNode.next;
       }
       return null;
    }

    @Override
    public Object set(Object value, int index) {
        Node currentNode = head;
        Node nextNode = null;
        Node previousNode = null;
        int currentSize = 0;
        while (currentNode != null) {
            if (currentSize == index){
                if(previousNode == null) {
                    head = new Node(value);
                    head.next = nextNode;
                    return head;
                }
                currentNode = new Node(value);
                previousNode.next = currentNode;
                currentNode.next = nextNode;
                return currentNode;
            }
            currentSize++;
            previousNode = currentNode;
            currentNode = currentNode.next;
            nextNode = currentNode.next;
        }
        return null;
    }

    private int indexOfRecurse(Object value, Node node,int index) {
        if (node == null) return -1;
        if(node.value.equals(value)) return index;
        else return indexOfRecurse(value, node.next, index + 1);
    }

    @Override
    public int indexOf(Object value) {
        return indexOfRecurse(value, head, 0);
    }

    public void revert() {
        Node current = head;
        Node previous = null;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    @Override
    public int lastIndexOf(Object value) {
        revert();
        int index = indexOf(value);
        revert();
        return index;
    }

    private String toStringRecurse(StringJoiner string, Node node){
        if (node == null) return string.toString();
        string.add(node.value.toString());
        return toStringRecurse(string, node.next);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        Iterator<Object> iterable = iterable();

        while (iterable.hasNext()){
            stringJoiner.add(iterable.next().toString());
        }

        return stringJoiner.toString();
    }

    @Override
    public Iterator<Object> iterable() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Object> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex != size();
        }

        @Override
        public Object next() {
            Object currentObject = get(currentIndex);
            currentIndex++;
            return currentObject;
        }
    }
}

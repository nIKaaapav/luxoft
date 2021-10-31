package datastructures.linkedList;

public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.printf("isEmpty = %s \n", linkedList.isEmpty());

        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        boolean found11 = linkedList.contains(11);
        boolean found33 = linkedList.contains(33);
        boolean found55 = linkedList.contains(55);
        System.out.printf("Size = %s \n", linkedList.size());
        System.out.printf("isEmpty = %s \n", linkedList.isEmpty());
        System.out.println(found11); // true
        System.out.println(found33); // true
        System.out.println(found55); // false
        System.out.println(linkedList.toString()); // 11,22,33,44
        Object remove = linkedList.remove(3);
        System.out.println(linkedList.toString()); // 11,33,44
        linkedList.remove(2);
        System.out.println(linkedList.toString()); // 11,44
        linkedList.remove(1);
        System.out.println(linkedList.toString()); // 11
        linkedList.remove(0);
        System.out.println(linkedList.toString()); // []
        System.out.printf("isEmpty = %s \n", linkedList.isEmpty());
    }
}

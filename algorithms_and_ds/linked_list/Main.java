package algorithms_and_ds.linked_list;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(8);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);

        linkedList.print();


        linkedList.removeDuplicates();

        linkedList.print();


        System.out.println(linkedList.nthToLast(2));
        System.out.println(linkedList.nthToLastIterative(2));
        System.out.println(linkedList.nthToLast(3));
        System.out.println(linkedList.nthToLastIterative(3));

        //////////////
        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.add(3);
        linkedList2.add(5);
        linkedList2.add(8);
        linkedList2.add(12);
        linkedList2.add(10);
        linkedList2.add(2);
        linkedList2.add(1);

        linkedList2.print();
        linkedList2.partition(5);
        linkedList2.print();

    }
}

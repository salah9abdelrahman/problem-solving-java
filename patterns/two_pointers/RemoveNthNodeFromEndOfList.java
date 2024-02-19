package patterns.two_pointers;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.createLinkedList(new int[]{3, 7, 1, 2, 8, 4, 5});

        linkedList.head = removeNthLastNode(linkedList.head, 7);

        printLinkedList(linkedList.head);


    }

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {

        LinkedListNode last = head;
        LinkedListNode previousToRemove = head;
        for (int i = 0; i < n; i++) {
            last = last.next;
        }

        if (last == null) {
            return head.next;
        }

        while (last.next != null) {
            last = last.next;
            previousToRemove = previousToRemove.next;
        }


        previousToRemove.next = previousToRemove.next.next;

        return head;
    }

    static public void printLinkedList(LinkedListNode head) {
        LinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
    }


}


class LinkedListNode {
    public int data;
    public LinkedListNode next;

    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    public LinkedListNode head;

    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }

    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }
}
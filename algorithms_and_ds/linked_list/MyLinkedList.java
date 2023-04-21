package algorithms_and_ds.linked_list;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedList<T> {

    Node head;

    public class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public MyLinkedList() {
        head = null;
    }

    public Node add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        return node;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(String.format("%s \t", node));
            node = node.next;
        }
        System.out.println();
    }

    /**
     * Time O(1)
     * Space O(n)
     */
    public void removeDuplicates() {
        Set<T> set = new HashSet<>();
        Node previous = null;
        Node node = head;
        while (node != null) {
            if (set.contains(node.data)) {
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

    /**
     * The Runner technique
     * Time O(n ^ 2)
     * Space O(1)
     */
    public void removeDuplicatesNoBuffer() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


}

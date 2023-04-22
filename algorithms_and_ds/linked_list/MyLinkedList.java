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

    class Index {
        public int val = 0;
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
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /**
     * Using recursion
     * Time O(n)
     * Space O(n)
     */
    public Node nthToLast(int k) {
        return nthToLast(head, k, new Index());
    }

    public Node nthToLast(Node head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        Node node = nthToLast(head.next, k, idx);
        idx.val += 1;
        if (idx.val == k) {
            return head;
        }
        return node;
    }

    /**
     * using Iteration
     * Time O(n)
     * Space O(1)
     */
    public Node nthToLastIterative(int k) {
        Node p1 = head;
        Node p2 = head;

        /* Move p1 k nodes into the list*/
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        /* Move them at the same place. When p1 hits the end, p2 will be the right element */
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;

    }


}

package algorithms_and_ds.linked_list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyLinkedList {

    Node head;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
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

    public Node add(int data) {
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
        Set<Integer> set = new HashSet<>();
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

    boolean deleteMiddleNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    void partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = null;
            if (current.data < x) {
                if (beforeStart == null) {
                    beforeStart = current;
                } else {
                    beforeEnd.next = current;
                }
                beforeEnd = current;

            } else {
                if (afterStart == null) {
                    afterStart = current;
                } else {
                    afterEnd.next = current;
                }
                afterEnd = current;
            }
            current = next;
        }
        if (beforeStart == null) {
            return;
        }
        beforeEnd.next = afterStart;
    }

    public static int addLists(Node node1, Node node2) {
        Node firstNode = node1;
        Node secondNode = node2;
        int result = 0;
        int count = 1;
        int reminder = 0;
        while (firstNode != null) {
            int x = firstNode.data + secondNode.data + reminder;
            int y = (x % 10) * count;
            result += y;
            reminder = x / 10;
            count *= 10;

            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return result;
    }

}

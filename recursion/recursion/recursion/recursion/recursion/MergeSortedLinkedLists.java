package recursion.recursion.recursion.recursion.recursion;
/*
https://leetcode.com/problems/merge-two-sorted-lists/editorial/
 */
public class MergeSortedLinkedLists {

    static public ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        if (n1.val <= n2.val) {
            n1.next = merge(n1.next, n2);
            return n1;
        } else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }

    public static void main(String[] args) {
        /*
        3->5->6->9
        1->2->7->10
         */

        ListNode n1 = new ListNode(3);
        n1.next = new ListNode(5);
        n1.next.next = new ListNode(6);
        n1.next.next.next = new ListNode(9);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(7);
        n2.next.next = new ListNode(10);
//        n2.next.next.next = new ListNode(11);
//        n2.next.next.next.next = new ListNode(15);

        ListNode head = merge(n1, n2);
        print(head);

    }

    static private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    static public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }
}

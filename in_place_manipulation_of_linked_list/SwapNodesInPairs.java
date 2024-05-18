package in_place_manipulation_of_linked_list;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPairs {

    /*
    Time O(n)
    space O(n)
    */
    static public ListNode swapPairs_rec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n1 = head;
        ListNode n2 = head.next;

        n1.next = swapPairs_rec(n2.next);
        n2.next = n1;

        return n2;
    }

    /*
    Time O(n)
    space O(1)
     */
    static public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode newHead = head.next;
        ListNode prev = null;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            ListNode nextOfNext = next.next;
            curr.next = nextOfNext;
            next.next = curr;
            if (prev != null) prev.next = next;
            prev = curr;
            curr = nextOfNext;
        }
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
//        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
//        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);

        head = swapPairs_rec(head);
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
        System.out.println();
    }
}

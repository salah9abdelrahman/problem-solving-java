package in_place_manipulation_of_linked_list;

/*
https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {
    static public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode mid = head;
        ListNode hare = head;
        ListNode prevToMid = null;
        while (hare != null && hare.next != null) {
            prevToMid = mid;
            mid = mid.next;
            hare = hare.next.next;
        }

        /* means even nodes so let's break the cycle */
        if(hare == null){
            prevToMid.next = null;
        }

        ListNode firstHead = head;
        ListNode secondHead = traverseListNode(mid);
        while (secondHead != null ) {

            ListNode nextOfFirstList = firstHead.next;
            ListNode nextOfSecondList = secondHead.next;

            firstHead.next = secondHead;
            secondHead.next = nextOfFirstList;

            firstHead = nextOfFirstList;
            secondHead = nextOfSecondList;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);
        print(head);
    }

    public static ListNode traverseListNode(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" + "data=" + data + '}';
        }
    }

    static public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}

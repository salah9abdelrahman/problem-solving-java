package in_place_manipulation_of_linked_list;

/*
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

         head = reverseList_leetCode(head);
//        head = reverseList_recursion(head);
        print(head);

    }

    /*
     * Time: O(n)
     * Space: O(1)
     */
    static public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = head;
            head = next;
        }
        return head;

    }

    static public ListNode reverseList_leetCode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /*
     * Time: O(n)
     * Space: O(n)
     */
    static public ListNode reverseList_recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList_recursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    static public class ListNode {
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

    }

    static public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
    }

}

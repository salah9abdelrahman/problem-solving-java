package patterns.fast_slow_patterns;

/*
https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        // ListNode node4 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        // node3.next = node4;
        // node4.next = node6;
        node3.next = node6;

        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        System.out.println(isPalindrome(head));

    }

    /*
     * Time: O(n)
     * Space: O(1)
     */

    static public boolean isPalindrome(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        if (hare != null) {
            tortoise = tortoise.next;
        }

        System.out.println(tortoise);

        tortoise = reverseLinkedList(tortoise);
        System.out.println(tortoise);

        while (tortoise != null) {
            if (head.val != tortoise.val) {
                return false;
            }
            tortoise = tortoise.next;
            head = head.next;
        }

        return true;

    }

    static public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = head;
            head = next;

        }
        return head;

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

        @Override
        public String toString() {
            return "ListNode [val=" + val + ", next=" + next + "]";
        }

    }
}

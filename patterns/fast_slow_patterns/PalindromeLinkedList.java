package patterns.fast_slow_patterns;

/*
https://leetcode.com/problems/palindrome-linked-list/description/
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode ln2 = new ListNode(6);
        ListNode ln3 = new ListNode(2);
        ListNode ln4 = new ListNode(8);
        ListNode ln5 = new ListNode(1);
        ListNode ln6 = new ListNode(8);
        ListNode ln7 = new ListNode(2);
        ListNode ln8 = new ListNode(6);
        ListNode ln9 = new ListNode(7);

        head.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = ln9;

        System.out.println(isPalindrome(head));


    }

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
}

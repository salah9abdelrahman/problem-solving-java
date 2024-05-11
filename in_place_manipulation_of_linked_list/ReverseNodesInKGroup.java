package in_place_manipulation_of_linked_list;

/*
https://leetcode.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodesInKGroup {

    /*
    Time O(N)
    Space O(1)
    */
    static public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode ktail = null;

        ListNode newHead = null;
        while (curr != null) {
            int count = 0;
            curr = head;

            while (count < k && curr != null) {
                curr = curr.next;
                count += 1;
            }

            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);
                if (newHead == null) newHead = revHead;
                if (ktail != null) ktail.next = revHead;
                ktail = head;
                head = curr;
            }
        }
        if (ktail != null) ktail.next = head;
        return newHead == null ? head : newHead;
    }

    /*
    Time O(N)
    Space O(N/k) due to recursion stack
     */
    static public ListNode reverseKGroup_recursion(ListNode head, int k) {
        int count = 0;
        ListNode ptr = head;
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = reverseLinkedList(head, k);
            head.next = reverseKGroup_recursion(ptr, k);
            return reversedHead;
        }
        return head;
    }


    static public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }
        return prev;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

//        head = reverseKGroup_recursion(head, 3);
        head = reverseKGroup(head, 3);
        print(head);
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

package in_place_manipulation_of_linked_list;

public class ReverseLinkedListII {
    static public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        int counter = 0;
        ListNode prevToLft = null;
        ListNode lft = left == 1 ? head : null;
        ListNode nxtToRight = null;
        ListNode curr = head;
        while (counter <= right - 1) {
            if (counter == left - 2 && lft == null) {
                prevToLft = curr;
                lft = curr.next;
            } else if (counter == right - 1) {
                nxtToRight = curr.next;
            }
            curr = curr.next;
            counter++;
        }

        ListNode newLeft = reverseLinkedList(lft, right - left + 1);
        if (left == 1) head = newLeft;
        if (prevToLft != null) prevToLft.next = newLeft;
        lft.next = nxtToRight;
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        head = reverseBetween(head, 1, 2);
        print(head);
    }

    static public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        while (k > 0 && curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            k--;
        }
        return prev;
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

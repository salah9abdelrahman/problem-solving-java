package in_place_manipulation_of_linked_list;

/*
https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
 */
public class ReverseNodesInEvenLengthGroups {


    public static ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next;
        ListNode theHead = head.next;
        ListNode prev = head;
        ListNode tail = null;
        int groupNum = 2;
        int count = 0;
        while (curr != null) {
            count = 0;
            while (curr != null && count < groupNum) {
                count++;
                if (groupNum % 2 != 0) {
                    prev = curr;
                }
                curr = curr.next;


            }
            if (count == groupNum) {
                if (count % 2 == 0) {
                    ListNode revHead = reverseList(theHead, count);
                    if (groupNum == 2) head.next = revHead;
                    if (tail != null) tail.next = revHead;
                    tail = theHead;
                    theHead = curr;
                } else {
                    tail.next = theHead;
                    theHead = curr;
                    tail = prev;
                }
            }
            groupNum++;

        }
        if (count > 0) {
            if (count % 2 == 0) {
                ListNode revHead = reverseList(theHead, count);
                tail.next = revHead;
            } else {
                if (tail != null) tail.next = theHead;
            }


        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
//        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
//        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);

        head = reverseEvenLengthGroups(head);
        print(head);
    }

    static public ListNode reverseList(ListNode head, int count) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && count > 0) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            count--;
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

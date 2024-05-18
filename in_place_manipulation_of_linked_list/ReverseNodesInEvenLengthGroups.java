package in_place_manipulation_of_linked_list;

/*
https://leetcode.com/problems/reverse-nodes-in-even-length-groups/description/
 */
public class ReverseNodesInEvenLengthGroups {

    /*
    Time O(n)
    Space O(1)
     */

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

 static    public ListNode reverseEvenLengthGroups_2(ListNode head) {
        int groupLen = 1;
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            int numOfNodes = 0;
            ListNode orgCurr = curr;
            ListNode orgPrev = prev;
            while(curr != null && numOfNodes < groupLen){
                prev = curr;
                curr = curr.next;
                numOfNodes++;
            }

            if(numOfNodes > 0 && numOfNodes % 2 == 0){
                ListNode headOfGroup = reverse(orgCurr, numOfNodes);
                orgPrev.next = headOfGroup;
                // 1->2->3->4->5
                // After first reverse
                // 1->3->2->4->5
                // 2 shoud be new prev
                prev = orgCurr;
            }
            groupLen++;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);

        head = reverseEvenLengthGroups_2(head);
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

   static public ListNode reverse(ListNode head, int groupLen){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null && groupLen > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            groupLen--;
        }

        // 1->2->3->4->5
        // as 2 came as head of the group
        // just setting up 2's next as 4
        head.next = next;
        return prev;
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

package patterns.fast_slow_pointers;

/*
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 */

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(7);
        ListNode n5 = new ListNode(9);
        // ListNode n6 = new ListNode(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        // n5.next = n6;

        System.out.println(detectCycle(n1));
    }

    static public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(hare == tortoise){
                break;
            }
            
        }


        if(hare == null ||  hare.next == null){
            return null;
        }

        hare = head;

        while (hare != tortoise) {
            tortoise = tortoise.next;
            hare = hare.next;
        }
        return hare;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode [val=" + val + "]";
        }

        
    }

}
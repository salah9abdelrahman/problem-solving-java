package fast_slow_pointers;
/**
 * https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(3);
        LinkedListNode n3 = new LinkedListNode(5);
        LinkedListNode n4 = new LinkedListNode(7);
        LinkedListNode n5 = new LinkedListNode(9);
        //        LinkedListNode n6 = new LinkedListNode(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        //        n5.next = n6;

        System.out.println(detectCycle(n1));
    }

    /**
     * Time O(n)
     * space O(1)
     */
    public static boolean detectCycle(LinkedListNode head) {
        LinkedListNode slowP = head;
        LinkedListNode fastP = head;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                return true;
            }
        }
        return false;
    }

    static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        // Constructor will be used to make a LinkedListNode type object
        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

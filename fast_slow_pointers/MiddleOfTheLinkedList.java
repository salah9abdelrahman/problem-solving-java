package fast_slow_pointers;

/*
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        n1.next = new LinkedListNode(2);
        n1.next.next = new LinkedListNode(3);
        n1.next.next.next = new LinkedListNode(4);
        n1.next.next.next.next = new LinkedListNode(5);
//        n1.next.next.next.next.next = new LinkedListNode(6);

        System.out.println(middleNode(n1));
    }

    /**
     * Time O(n)
     * Space O(1)
     */
    public static LinkedListNode middleNode(LinkedListNode head) {
        LinkedListNode slowP = head;
        LinkedListNode fastP = head;
        while (fastP != null && fastP.next !=null){
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        return slowP;
    }

    static class LinkedListNode {
        public int data;
        public LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "LinkedListNode{" + "data=" + data + '}';
        }
    }
}

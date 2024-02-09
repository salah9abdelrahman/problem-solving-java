package patterns.fast_slow_patterns;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        LinkedListNode n5 = new LinkedListNode(5);
        LinkedListNode n6 = new LinkedListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

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

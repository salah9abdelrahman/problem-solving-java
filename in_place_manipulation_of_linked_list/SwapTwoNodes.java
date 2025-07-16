package in_place_manipulation_of_linked_list;

import java.util.HashSet;
import java.util.Set;

public class SwapTwoNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4
//                                        ,
//                                        new ListNode(5,
//                                                new ListNode(6)
//                                        )
                                )
                        )
                )
        );
  head=  new SwapTwoNodes_Solution().reverseTwoNodes(head, 1, 4);
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
        printList(head);
    }

    public static void printList(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) {
                System.out.println("Cycle detected at node " + head.val);
                return;
            }
            seen.add(head);
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}


class SwapTwoNodes_Solution {
    public ListNode reverseTwoNodes(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        int count = 1;
        ListNode leftPrevNode = null, leftNode = null, rightPervNode = null, rightNode = null, rightNextNode = null;
        ListNode curr = head;
        while (curr != null) {
            if (count == left - 1 && left != 1) {
                leftPrevNode = curr;
            } else if (count == left) {
                leftNode = curr;
            } else if (count == right - 1) {
                rightPervNode = curr;
            } else if (count == right) {
                rightNode = curr;
            } else if (count == right + 1) {
                rightNextNode = curr;
            }
            curr = curr.next;
            count++;
        }
        if(leftPrevNode != null){
            leftPrevNode.next = rightNode;
        }else {
            head = rightNode;
        }
        if(left + 1 != right){
            rightPervNode.next = leftNode;
            rightNode.next = leftNode.next;
        }else {
            rightNode.next = leftNode;
        }

        leftNode.next = rightNextNode;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode nextNode) {
        this.val = val;
        this.next = nextNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val
                +
//                ", next=" + next +
                '}'
                ;
    }


}

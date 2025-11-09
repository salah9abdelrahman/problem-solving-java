//  https://leetcode.com/problems/reverse-linked-list-ii/description/
package in_place_manipulation_of_linked_list;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head = new ReverseLinkedListIISolution().reverseBetween_educative(head, 2, 5);
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }
}


class ReverseLinkedListIISolution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode currToGetRefs = head;
        ListNode prevToLeft = null;
        ListNode nextToRightN = null;
        ListNode leftN = null;
        ListNode rightN = null;
        int counter = 1;
        while (currToGetRefs != null) {
            if (counter == left - 1) {
                prevToLeft = currToGetRefs;
            } else if (counter == right + 1) {
                nextToRightN = currToGetRefs;
                break;
            } else if (counter == left) {
                leftN = currToGetRefs;
            } else if (counter == right) {
                rightN = currToGetRefs;
            }
            currToGetRefs = currToGetRefs.next;
            counter++;
        }
        ListNode prev = null;
        ListNode curr = leftN;
        int i = right - left;
        while (i >= 0) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
            i--;
        }
        if (left == 1) {
            head = rightN;
        } else {
            prevToLeft.next = prev;
        }
        leftN.next = nextToRightN;

        return head;
    }

    ListNode reverseBetween_educative(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
    }

}

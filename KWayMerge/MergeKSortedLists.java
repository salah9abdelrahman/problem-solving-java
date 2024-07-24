// https://leetcode.com/problems/merge-k-sorted-lists/description/

package KWayMerge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode output = mergeKLists(lists);
        while (output.next != null) {
            System.out.print(output + " -> ");
            output = output.next;
        }

    }

    /**
     * Time: O(n log n)
     * space O(n)
     */

    static public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = new ListNode(-1);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.val)
        );
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);

            }
        }
        ListNode curr;
        while (!heap.isEmpty()) {
            curr = heap.poll();
            if (output.next == null) {
                output.next = curr;
            }
            if (curr.next != null) {
                heap.add(curr.next);
            }
            curr.next = heap.peek();

        }
        return output.next;
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

}

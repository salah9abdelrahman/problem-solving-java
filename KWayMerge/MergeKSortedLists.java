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
        ListNode output = mergeKLists_usingHeap(lists);
        while (output.next != null) {
            System.out.print(output + " -> ");
            output = output.next;
        }

    }

    /**
     * Time: O(n log n)
     * space O(n)
     */

    static public ListNode mergeKLists_usingHeap(ListNode[] lists) {
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

    /**
     * Time: O(n log n)
     * space O(1)
     */
    static public ListNode mergeKLists_usingMergeSortTweak(ListNode[] lists) {
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += interval * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return amount > 0 ? lists[0] : null;
    }

    static public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l1;
                l1 = point.next.next;
            }
            point = point.next;
        }
        if (l1 == null) {
            point.next = l2;
        } else {
            point.next = l1;
        }
        return head.next;
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

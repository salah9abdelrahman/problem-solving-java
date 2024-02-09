package leetcode.study_plan_data_structure_I;

/**
 * https://leetcode.com/problems/linked-list-cycle/editorial/?envType=study-plan&id=data-structure-i?envType=study-plan&id=data-structure-i
 */

import java.util.HashSet;


public class LinkedListCycle {

        /***
        Time O(n)
         Space O(n)
         */
    static public boolean hasCycle_hashing(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode n = head;
        while (n != null){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
            n = n.next;
        }
        return false;
    }

    public static void main(String[] args) {

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

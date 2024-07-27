//215. Kth Largest Element in an Array https://leetcode.com/problems/kth-largest-element-in-an-array/description/

package top_k_elements;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }

    /**
     * Time O(n log k)
     * Space O(k)
     *
     * @param nums
     * @param k
     * @return
     */

    static public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap.add(nums[i]);
            } else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}

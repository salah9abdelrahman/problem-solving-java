//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
package top_k_elements;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));


    }

    /**
     * Time O(n log k)
     */
    static class KthLargest {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            if (nums.length == 0) {
                return;
            }
            for (int i = 0; i < k && i < nums.length; i++) {
                heap.add(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                addToHeap(nums[i]);
            }

        }

        private void addToHeap(int val) {
            if (this.k > heap.size()) {
                heap.add(val);
            } else if (val > heap.peek()) {
                heap.poll();
                heap.add(val);
            }
        }


        /**
         * Time O(log k)
         *
         * @param val
         * @return
         */
        public int add(int val) {
            addToHeap(val);
            return heap.peek();
        }
    }

}

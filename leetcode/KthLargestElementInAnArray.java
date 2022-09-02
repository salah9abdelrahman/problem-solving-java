package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest_sort(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest_sort(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(findKthLargest_heap(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest_heap(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    /*
     O( N log N)
     */
    static public int findKthLargest_sort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /*
      O( N log k)
     */
    static public int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> heapK = new PriorityQueue<>(Comparator.comparingInt(n -> n));
        for (int i : nums
             ) {
            heapK.add(i);
            if(heapK.size() > k){
                heapK.poll();
            }
        }

        return heapK.poll();
    }
}

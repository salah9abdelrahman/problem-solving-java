// 704. Binary Search https://leetcode.com/problems/binary-search/description/
package modified_binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5}, 5));
    }


}

class Solution {
    /*
     * Time O(log n)
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
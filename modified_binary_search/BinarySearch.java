// 704. Binary Search https://leetcode.com/problems/binary-search/description/
package modified_binary_search;

public class BinarySearch {
    public static void main(String[] args) {
//        System.out.println(new BinarySearchSolution().search(new int[]{5}, 5));
        System.out.println(new BinarySearchSolution().search(new int[]{1,3}, 3));
    }


}

class BinarySearchSolution {
    /*
     * Time O(log n)
     * Space O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            /*
            Why not  mid = (left + right) /2?
            to avoid the possibility of overflow from left + right if both of them are hugh numbers
             */
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

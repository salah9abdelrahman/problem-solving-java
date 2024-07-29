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
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            /*
            Why not  mid = (start + end) /2?
            to avoid the possibility of overflow from start + end if both of them are hugh numbers
             */
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

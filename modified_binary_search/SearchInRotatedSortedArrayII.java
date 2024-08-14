//https://leetcode.com/problems/search-in-rotated-sorted-array-ii
package modified_binary_search;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {

    }
}

class SearchInRotatedSortedArrayIISolution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            // which array does pivot belong to.
            boolean pivotArray = nums[start] <= nums[mid];

            // which array does target belong to.
            boolean targetArray = nums[start] <= target;
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotArray) {
                    start = mid + 1; // pivot in the first, target in the second
                } else {
                    end = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}

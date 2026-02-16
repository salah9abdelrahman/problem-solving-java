package two_pointers;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 */

public class TwoSum {
    public static void main(String[] args) {
    }
}


class TwoSum_Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int sum = nums[l] + nums[r];
        while (sum != target) {
            if (sum > target) {
                r--;
            } else {
                l++;
            }
            sum = nums[l] + nums[r];
        }
        return new int[] { l+1, r +1};
    }
}

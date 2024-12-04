// https://leetcode.com/problems/matchsticks-to-square
package backtracking;

import java.util.Arrays;
import java.util.Collections;

public class MatchsticksTtoSquare {
    public static void main(String[] args) {
//        System.out.println(new MatchsticksTtoSquare_backtracking_Solution().makesquare(new int[]{1, 1, 2, 2, 2})); // true
//        System.out.println(new MatchsticksTtoSquare_backtracking_Solution().makesquare(new int[]{3, 3, 3, 3, 4})); // false;
//        System.out.println(new MatchsticksTtoSquare_backtracking_Solution().makesquare(new int[]{2, 2, 2, 3, 4, 4, 4, 5, 6})); // true
        System.out.println(new MatchsticksTtoSquare_backtracking_Solution().makesquare(new int[]{2, 2, 2, 2, 2, 6})); // false
//        System.out.println(new MatchsticksTtoSquare_backtracking_Solution().makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3})); // true
    }
}

/**
 * @time O(4 ^ N)
 * @space O(n)
 */
class MatchsticksTtoSquare_backtracking_Solution {
    public int[] buckets;
    public int sideSize;


    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        sideSize = sum / 4;
        if (sideSize * 4 != sum) {
            return false;
        }

        // Convert to Integer array for reverse sorting
        Integer[] numsSorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Sort in reverse order
        Arrays.sort(numsSorted, Collections.reverseOrder());
        return backtrack(numsSorted, 0);
    }

    public MatchsticksTtoSquare_backtracking_Solution() {
        this.buckets = new int[4];
    }

    private boolean backtrack(Integer[] nums, int index) {
        // If we have exhausted all our matchsticks, check if all sides of the square are of equal length
        if (index == nums.length) {
            return buckets[0] == sideSize && buckets[1] == sideSize && buckets[2] == sideSize &&  buckets[3] == sideSize;
        }

        int element = nums[index];

        // Try adding it to each of the 4 sides (if possible)
        for (int i = 0; i < 4; i++) {
            if (buckets[i] + element <= sideSize) {
                buckets[i] += element;
                if (backtrack(nums, index + 1)) {
                    return true;
                }
                buckets[i] -= element;
            }
        }
        return false;
    }

}
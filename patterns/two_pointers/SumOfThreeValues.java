package patterns.two_pointers;

import java.util.Arrays;

public class SumOfThreeValues {
    public static void main(String[] args) {
        System.out.println(sumOfThreeValues(new int[]{3, 7, 1, 2, 8, 4, 5}, 20));
        System.out.println(sumOfThreeValues(new int[]{3, 7, 1, 2, 8, 4, 6}, 20));
    }

    /**
     * Time O(n ** 2)
     * Space O(1)
     */

    static boolean sumOfThreeValues(int[] nums, int target) {
        Arrays.sort(nums);
        int low;
        int high;
        int sum;
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return true;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return false;
    }
}

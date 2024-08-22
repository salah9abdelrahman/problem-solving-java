// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
package backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class PartitionToKEqualSumSubsets {
    public static void main(String[] args) {
        System.out.println(new PartitionToKEqualSumSubsetsBacktrackingWithMemoizationSolution().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(new PartitionToKEqualSumSubsetsBacktrackingWithMemoizationSolution().canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4));
    }
}

class PartitionToKEqualSumSubsetsBacktrackingSolution {
    /**
     * @time o(k * 2 ^ n)
     * @space o(n)
     */

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;
        boolean[] taken = new boolean[n];

        return backtrack(arr, 0, 0, 0, k, targetSum, taken);
    }

    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, boolean[] taken) {


        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            return backtrack(arr, 0, count + 1, 0, k, targetSum, taken);
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < arr.length; ++j) {
            if (!taken[j]) {
                // Include this element in current subset.
                taken[j] = true;

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = false;
            }
        }

        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }


    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


class PartitionToKEqualSumSubsetsBacktrackingWithMemoizationSolution {

    /**
     * @time o(k * 2 ^ n)
     * @space o(n)
     */
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        // If total sum not divisible by k, we can't make subsets.
        if (totalArraySum % k != 0) {
            return false;
        }

        // Sort in decreasing order.
        Arrays.sort(arr);
        reverse(arr);

        int targetSum = totalArraySum / k;

        char[] taken = new char[n];
        for (int i = 0; i < n; ++i) {
            taken[i] = '0';
        }

        // Memoize the ans using taken element's string as key.
        HashMap<String, Boolean> memo = new HashMap<>();

        return backtrack(arr, 0, 0, 0, k, targetSum, taken, memo);
    }

    private boolean backtrack(int[] arr, int index, int count, int currSum, int k,
                              int targetSum, char[] taken, HashMap<String, Boolean> memo) {

        int n = arr.length;

        // We made k - 1 subsets with target sum and last subset will also have target sum.
        if (count == k - 1) {
            return true;
        }

        // No need to proceed further.
        if (currSum > targetSum) {
            return false;
        }

        String takenStr = new String(taken);

        // If we have already computed the current combination.
        if (memo.containsKey(takenStr)) {
            return memo.get(takenStr);
        }

        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if (currSum == targetSum) {
            boolean ans = backtrack(arr, 0, count + 1, 0, k, targetSum, taken, memo);
            memo.put(takenStr, ans);
            return ans;
        }

        // Try not picked elements to make some combinations.
        for (int j = index; j < n; ++j) {
            if (taken[j] == '0') {
                // Include this element in current subset.
                taken[j] = '1';

                // If using current jth element in this subset leads to make all valid subsets.
                if (backtrack(arr, j + 1, count, currSum + arr[j], k, targetSum, taken, memo)) {
                    return true;
                }

                // Backtrack step.
                taken[j] = '0';
            }
        }

        // We were not able to make a valid combination after picking each element from array,
        // hence we can't make k subsets.
        memo.put(takenStr, false);
        return false;
    }

    void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}


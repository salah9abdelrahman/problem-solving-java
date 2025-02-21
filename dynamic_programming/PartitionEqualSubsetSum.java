//https://leetcode.com/problems/partition-equal-subset-sum/description/

package dynamic_programming;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
//        System.out.println(new PartitionEqualSubsetSumSolution_topDown().canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(new PartitionEqualSubsetSumSolution_topDown().canPartition(new int[]{1, 2, 3, 4}));
        System.out.println(new PartitionEqualSubsetSumSolution_bottomUp().canPartition(new int[]{1, 2, 3, 4}));
//        System.out.println(new PartitionEqualSubsetSumSolution_topDown().canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }
}

/**
 * @time O(mn), where m = half of the sum
 * @space o(mn)
 */
class PartitionEqualSubsetSumSolution_topDown {
    public boolean canPartition(int[] arr) {
        int totalArraySum = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            totalArraySum += arr[i];
        }

        if (totalArraySum % 2 != 0) {
            return false;
        }

        // n(totalArraySum / 2 + 1) possible unique call
        Boolean[][] memo = new Boolean[arr.length + 1][totalArraySum / 2 + 1];

        return dfs(arr, totalArraySum / 2, 0, memo);
    }

    /*
    index: 0 -> n-1
    sum: totalArraySum -> 0
     */
    private boolean dfs(int[] arr, int sum, int index, Boolean[][] memo) {
        if (sum == 0) return true;
        if (index == arr.length || sum < 0) return false;
        if (memo[index][sum] != null) return memo[index][sum];

        boolean result = dfs(arr, sum - arr[index], index + 1, memo) || dfs(arr, sum, index + 1, memo);
        memo[index][sum] = result;
        return result;
    }
}

/**
 * @time O(mn), where m = half of the sum
 * @space o(mn)
 */
class PartitionEqualSubsetSumSolution_bottomUp {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][subSetSum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 0; j <= subSetSum; j++) {
                if (j < curr)
                    dp[i][j] = dp[i - 1][j];
                else
                    // without including curr || with including curr
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curr];
            }
        }
        return dp[n][subSetSum];
    }
}
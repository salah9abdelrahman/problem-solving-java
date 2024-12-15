//https://leetcode.com/problems/coin-change/editorial/
package dynamic_programming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChangeSolution_bottomUp().coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(new CoinChangeSolution_topDown().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }


}
/**
 * @time O(A * N) A = amount, N = coins.len
 * @space O(A)
 */
class CoinChangeSolution_topDown {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount, new int[amount + 1]);
    }

    int monCount = Integer.MAX_VALUE;

    private int dp(int[] coins, int amount, int[] memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo[amount] != 0) return memo[amount];
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = dp(coins, amount - coin, memo);
            if (count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }
        memo[amount] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        return memo[amount];
    }
}

/**
 * @time O(A * N) A = amount, N = coins.len
 * @space O(A)
 */
class CoinChangeSolution_bottomUp {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] tabu = new int[amount + 1];
        Arrays.fill(tabu, max);
        tabu[0] = 0;
        for (int subAmount = 1; subAmount <= amount; subAmount++) {
            for (int coin : coins) {
                if (coin <= subAmount) {
                    int rem = subAmount - coin;
                    tabu[subAmount] = Math.min(tabu[subAmount], tabu[rem] + 1);
                }
            }
        }
        return tabu[amount] > amount ? -1 : tabu[amount];
    }
}
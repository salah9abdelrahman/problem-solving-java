//https://www.educative.io/courses/grokking-coding-interview/0-1-knapsack
package dynamic_programming;

public class knapsack {
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxKnapsackProfit(30, new int[]{10, 20, 30}, new int[]{22, 33, 44}));
    }
}

class Solution {
    public int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        return bottomUp(capacity, weights, values);
    }

    private static int bottomUp(int capacity, int[] weights, int[] values) {
        int[][] tabu = new int[values.length + 1][capacity + 1];
        // over items
        for (int value = 1; value <= values.length; value++) {
            // over weights
            for (int weight = 1; weight <= capacity; weight++) {
                if (weights[value - 1] <= weight) {
                    tabu[value][weight] = Math.max(tabu[value - 1][weight],
                            values[value - 1] + tabu[value - 1][weight - weights[value - 1]]);
                } else {
                    tabu[value][weight] = tabu[value - 1][weight];
                }
            }
        }

        return tabu[values.length][capacity];
    }
}



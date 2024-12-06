// https://leetcode.com/problems/climbing-stairs/description/
package dynamic_programming;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairsSolution().climbStairs(5));
    }
}

class ClimbingStairsSolution {
    public int climbStairs(int n) {
//        return topDownDp(new HashMap<>(), n);
        return bottomUp(n);
    }

    private int bottomUp(int n) {
        int[] tabu = new int[n + 1];
        tabu[0] = 1;
        tabu[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            tabu[i] = tabu[i - 1] + tabu[i - 2];
        }
        return tabu[n];
    }

    private int topDownDp(HashMap<Integer, Integer> memo, int n) {
        if (n <= 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, topDownDp(memo, n - 1) + topDownDp(memo, n - 2));
        return memo.get(n);
    }
}

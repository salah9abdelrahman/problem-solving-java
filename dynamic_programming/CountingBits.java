//https://leetcode.com/problems/counting-bits/description/

package dynamic_programming;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBitsSolution_DP().countBits(4)));
    }
}

/**
 * @time O(n)
 */
class CountingBitsSolution_DP{
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        if (n == 0) {
            return result;
        }

        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                result[i] = result[i / 2];
            } else {
                result[i] = result[i / 2] + 1;

            }
        }
        return result;

    }
}

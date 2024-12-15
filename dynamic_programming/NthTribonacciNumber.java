// https://leetcode.com/problems/n-th-tribonacci-number/description/
package dynamic_programming;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber_bottomUp_Solution().tribonacci(4));
        System.out.println(new NthTribonacciNumber_bottomUp_Solution().tribonacci(5));
        System.out.println(new NthTribonacciNumber_bottomUp_Solution().tribonacci(25));
    }
}

/**
 * @time O(n)
 * @space O(1)
 */
class NthTribonacciNumber_bottomUp_Solution {
    public int tribonacci(int n) {
        int[] arr = new int[]{0,1,1};
        for (int i = 0; i <= n -3; i++) {
            arr[i%3] = arr[0] + arr[1] + arr[2];
        }
        return arr[n%3];
    }
}

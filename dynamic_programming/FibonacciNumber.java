// https://leetcode.com/problems/fibonacci-number/description/
package dynamic_programming;

public class FibonacciNumber {

}

class FibonacciNumber_bottomUp_Solution {
    public int fib(int n) {
        int[] arr = new int[]{0,1};
        for (int i = 0; i <= n -2; i++) {
            arr[i%2] = arr[0] + arr[1];
        }
        return arr[n%2];
    }
}
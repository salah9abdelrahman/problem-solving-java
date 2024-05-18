package recursion.recursion.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        // System.out.println(recursive(2));
        // System.out.println(recursive(5));
        // System.out.println(recursive(6));
        // System.out.println(recursive(7));
        // System.out.println("***************");
        // System.out.println(iterative(2));
        // System.out.println(iterative(5));
        // System.out.println(iterative(6));
        // System.out.println(iterative(7));
        // System.out.println("***************");
        // System.out.println(dynamic_programming(2));
        // System.out.println(dynamic_programming(4));
        // System.out.println(dynamic_programming(6));
        // System.out.println(dynamic_programming(7));
        System.out.println("***************");
        System.out.println(DPBottomUpTabulation(2));
        System.out.println(DPBottomUpTabulation(4));
        System.out.println(DPBottomUpTabulation(6));
        System.out.println(DPBottomUpTabulation(7));
    }

    // Complexity : o(2^n)
    static long recursive(int n) {
        if (n < 2) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    // Complexity : o(n)
    static long iterative(int n) {
        long num1, num2 = 0, currentNumber = 1;
        for (long i = 1; i < n; i++) {

            num1 = num2;
            num2 = currentNumber;
            currentNumber = num1 + num2;
        }
        return currentNumber;
    }

    static long dynamic_programming(int n) {
        long[] memoize = new long[n + 1];
        return DPTopDownMemoization(memoize, n);
    }

    static long DPTopDownMemoization(long[] memoize, int n) {
        if (n < 2) {
            return n;
        }

        // if we have already solved this subproblem,
        // simply return the result from the cache
        if (memoize[n] != 0) {
            return memoize[n];
        }

        memoize[n] = DPTopDownMemoization(memoize, n - 1) + DPTopDownMemoization(memoize, n - 2);
        return memoize[n];
    }

    static long DPBottomUpTabulation(int n) {
        if (n == 0) {
            return 0;
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
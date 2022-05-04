package AlgorithmsAndDS;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {
    public static void main(String[] args) {
        Arrays.stream(decreasingMonotonicStack(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).forEach(i -> System.out.print(i + " "));

    }
    public static int[] decreasingMonotonicStack(int[] X) {
        int[] ans = new int[X.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = X.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= X[i]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? -1 : stack.peek();
            stack.push(X[i]);
        }
        return ans;
    }
}

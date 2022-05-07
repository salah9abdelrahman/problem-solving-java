package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Monotonic Stack
 */
public class DailyTemperatures {
    public static void main(String[] temperatures) {

        Arrays.stream(dailyTemperatures_bruteForce(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(dailyTemperatures_monotonicStack(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).forEach(i -> System.out.print(i + " "));
    }

    public static int[] dailyTemperatures_bruteForce(int[] temperatures) {
        // o(n^2)
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }

        }
        ans[temperatures.length - 1] = 0;
        return ans;
    }

    public static int[] dailyTemperatures_monotonicStack(int[] temperatures) {
        // o(n)
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return ans;
    }
}

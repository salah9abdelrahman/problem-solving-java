package fast_slow_pointers;

/**
 * https://leetcode.com/problems/happy-number/description/
 */

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(999));
    }

    /**
     * Time O(n)
     * Space O(1)
     */
    public static boolean isHappyNumber(int n) {
        int slowPointer = n; // The slow pointer value
        int fastPointer = sumOfSquaredDigits(n);
        while (fastPointer != 1 && slowPointer != fastPointer) {
            slowPointer = sumOfSquaredDigits(slowPointer);
            fastPointer = sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
        }
        return fastPointer == 1;
    }

    public static int sumOfSquaredDigits(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result += digit * digit;
            n = n / 10;

        }
        return result;
    }

}

package patterns.fast_slow_pointers;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/circular-array-loop/description/
 */

public class CircularArrayLoop {

    public static void main(String[] args) {
        System.out.println(circularArrayLoop_twoPointers(new int[] { 1, 3, -2, -4, 1 }));
    }

    /*
     * Time O(n)^2
     * space O(1)
     */

    public static boolean circularArrayLoop_twoPointers(int[] nums) {
        int size = nums.length;
        // Iterate through each index of the array 'nums'.
        for (int i = 0; i < size; i++) {
            // Set slow and fast pointer at current index value.
            int slow = i, fast = i;
            // Set true in 'forward' if element is positive, set false otherwise.
            boolean forward = nums[i] > 0;

            while (true) {
                // Move slow pointer to one step.
                slow = nextStep(slow, nums[slow], size);
                // If cycle is not possible, break the loop and start from next element.
                if (isNotCycle(nums, forward, slow))
                    break;

                // First move of fast pointer.
                fast = nextStep(fast, nums[fast], size);
                // If cycle is not possible, break the loop and start from next element.
                if (isNotCycle(nums, forward, fast))
                    break;

                // Second move of fast pointer.
                fast = nextStep(fast, nums[fast], size);
                // If cycle is not possible, break the loop and start from next element.
                if (isNotCycle(nums, forward, fast))
                    break;

                // At any point, if fast and slow pointers meet each other,
                // it indicates that loop has been found, return true.
                if (slow == fast)
                    return true;
            }
        }

        return false;
    }

    // A function to calculate the next step
    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0)
            result += size;
        return result;
    }

    // A function to detect a cycle doesn't exist
    public static boolean isNotCycle(int[] nums, boolean prevDirection, int pointer) {
        // Set current direction to true if current element is positive, set false
        // otherwise.
        boolean currDirection = nums[pointer] >= 0;

        // If current direction and previous direction are different or moving a pointer
        // takes back to the same value,
        // then the cycle is not possible, we return true, otherwise return false.
        if (prevDirection != currDirection || Math.abs(nums[pointer] % nums.length) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Another solution:
     * Time O(n) ^2
     * space O(n)
     * two pointers is better due to space complicity
     */

    public static boolean circularArrayLoop(int[] nums) {
        boolean forward = true;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> v = new HashSet<>();
            int k = 0;
            if (nums[i] > 0) {
                forward = true;
            } else {
                forward = false;
            }
            int j = i;
            while (true) {
                if ((nums[j] > 0 && !forward) || (nums[j] < 0 && forward)) {
                    break;
                }

                k++;

                j = (nums[j] + j) % nums.length;
                if (j < 0) {
                    j += nums.length;
                }
                if (i == j && k == 1) {
                    break;
                } else if (i == j & k > 1) {
                    return true;
                }
                if (v.contains(j)) {
                    break;
                }

                v.add(j);

            }

        }

        return false;
    }
}
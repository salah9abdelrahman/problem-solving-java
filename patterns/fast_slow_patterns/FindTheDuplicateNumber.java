package patterns.fast_slow_patterns;

/*
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * constraints: You must solve the problem without modifying the array nums and uses only constant extra space.
 */

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        // System.out.println(findDuplicate_negativeMarking(new int[] { 1, 5, 4, 3, 2,
        // 4, 6 }));
        // System.out.println(findDuplicate_ArrayAsHashMap(new int[] { 1, 5, 4, 3, 2, 4,
        // 6 }));
        System.out.println(findDuplicate_cyclicSort(new int[] { 1, 5, 4, 3, 2, 4, 6 }));

    }

    /*
     * Time: O(n)
     * Space O(1)
     */
    static public int findDuplicate_negativeMarking(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr] < 0) {
                duplicate = curr;
                break;
            }
            nums[curr] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }

    /*
     * Time: O(n)
     * Space O(n) due to recursion
     */

    static public int findDuplicate_ArrayAsHashMap(int[] nums) {
        return store(nums, 0);
    }

    static public int store(int[] nums, int cur) {
        if (cur == nums[cur])
            return cur;
        int nxt = nums[cur];
        nums[cur] = cur;
        return store(nums, nxt);
    }

    /*
     * same idea as findDuplicate_ArrayAsHashMap
     * Time: O(n)
     * Space O(1)
     */
    static public int findDuplicate_cyclicSort(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }

}

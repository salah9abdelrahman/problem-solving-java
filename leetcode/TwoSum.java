package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    /*
    runtime O(n)
    space O(n)
     */
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (hash.containsKey(x)) {
                res[0] = i;
                res[1] = hash.get(x);
            }
            hash.put(nums[i], i);
        }

        return res;
    }
}

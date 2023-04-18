package leetcode.study_plan_data_structure_I;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersect(new int[]{3, 1, 2}, new int[]{1, 1})));
    }

    /*
    Time O(n + m)
    Space Complexity: O(min(n + m))
     */
    static public int[] intersect(int[] nums1, int[] nums2) {
        // to hash map the smaller arr
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums1) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }

        int j = 0;
        for (int num : nums2) {
            int currCount = hash.getOrDefault(num, 0);
            if (currCount > 0) {
                nums1[j++] = num;
                hash.put(num, currCount - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, j);

    }

}

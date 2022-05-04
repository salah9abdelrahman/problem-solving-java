package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */

public class NextGreaterElementI {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).forEach(i -> System.out.print(i + " "));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // O(n * m)
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hash.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        int j;
        for (int i = 0; i < nums1.length; i++) {
            for (j = hash.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }

            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }
        return res;
    }
}

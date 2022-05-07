package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */

public class NextGreaterElementI {
    public static void main(String[] args) {
        Arrays.stream(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Arrays.stream(nextGreaterElement_monotonicStack(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).forEach(i -> System.out.print(i + " "));

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


    public static int[] nextGreaterElement_monotonicStack(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        // map works because it said in the problem it is a set, otherwise it won't
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : nums2) {
            while (!stack.empty() && j > stack.peek()) {
                map.put(stack.pop(), j);
            }
            stack.push(j);
        }
        while (!stack.empty()){
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

}

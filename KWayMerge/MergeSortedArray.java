package KWayMerge;
/*
https://leetcode.com/problems/merge-sorted-array/editorial/
 */

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{ 0};
//        int[] nums2 = new int[]{1};
//        merge(nums1, 0, nums2, 1);

        int[] nums1 = new int[]{0, 0, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        merge(nums1, 0, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

    /*
    Time: O(m+n)
    Space: O(1)
     */
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
    }
}

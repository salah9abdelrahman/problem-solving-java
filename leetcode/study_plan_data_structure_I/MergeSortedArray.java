package leetcode.study_plan_data_structure_I;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(nums1));

        int[] nums12 = new int[]{2, 0};
        merge(nums12, 1, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums12));
    }

    /*
    Time O(n+m)
    space O(n+m)
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p2 < n && (p1 == m || nums1[p1] >= nums2[p2])) {
                res[i] = nums2[p2];
                p2++;
            } else {
                res[i] = nums1[p1];
                p1++;
            }
        }
        for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }

    /*
        Time O(n+m)
        space 1
     */
    public void merge_noSpace(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}

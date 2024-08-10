// https://leetcode.com/problems/find-k-closest-elements/description/
package modified_binary_search;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static void main(String[] args) {
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{1, 2, 3, 4, 5, 6, 7}, 4, 5)); // 3,4,5,6
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)); // 1,2,3,4
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4)); //0, 1, 1, 1, 2, 3, 6, 7, 8
        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)); // 10
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3));  // arr
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));  //1,2,3,4
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 99));  // 2,3,4,5
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));  // 3,3,4
//        System.out.println(new BinarySearchSlidingWindowSolution().findClosestElements(new int[]{1, 3, 4, 7, 8, 13, 14}, 3, 5));  // 3,3,4
    }
}

class BinarySearchSlidingWindowSolution {
    /**
     Time O( log(n) + k)
     Space O(k)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);

        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }

            return result;
        }

        // Binary search to find the closest element
        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Initialize our sliding window's bounds
        left -= 1;
        right = left + 1;

        // While the window size is less than k
        while (right - left - 1 < k) {
            // Be careful to not go out of bounds
            if (left == -1) {
                right += 1;
                continue;
            }

            // Expand the window towards the side with the closer number
            // Be careful to not go out of bounds with the pointers
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left -= 1;
            } else {
                right += 1;
            }
        }

        // Build and return the window
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}

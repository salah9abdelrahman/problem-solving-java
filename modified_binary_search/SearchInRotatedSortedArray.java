// 33. Search in Rotated Sorted Array https://leetcode.com/problems/search-in-rotated-sorted-array/description/
package modified_binary_search;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArraySolution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new SearchInRotatedSortedArraySolution().search(new int[]{6, 7, 1, 2, 3, 4, 5}, 6));
        System.out.println(new SearchInRotatedSortedArraySolution().search(new int[]{5, 1, 3}, 3));
        System.out.println(new SearchInRotatedSortedArraySolution().search(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 1));

    }
}

class SearchInRotatedSortedArraySolution {
    /**
     * Time O(log n)
     * Space O(1)
     */
    public int search(int[] nums, int target) {
        // pivot is the index of the smallest value
        int pivot = searchForPivot(nums);

        int searchFirstHalf = binarySearch(nums, target, pivot, nums.length - 1);
        if (searchFirstHalf != -1) {
            return searchFirstHalf;
        }

        return binarySearch(nums, target, 0, pivot - 1);
    }

    private int searchForPivot(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

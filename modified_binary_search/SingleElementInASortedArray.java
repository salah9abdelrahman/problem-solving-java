// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
package modified_binary_search;


public class SingleElementInASortedArray {
    public static void main(String[] args) {
        System.out.println(new SingleElementInASortedArrayBSSolution().singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(new SingleElementInASortedArrayBSSolution().singleNonDuplicate(new int[]{1, 2, 2, 3, 3, 4, 4, 8, 8}));
    }
}

class SingleElementInASortedArrayBSSolution {
    /*
    Time O(log n)
    Space O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean halvesAreEven = mid % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (halvesAreEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (halvesAreEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }

        }
        return nums[low];
    }
}

class BinarySearchOnEvensIndexesOnly {
    /*
    Time O(log n)
    Space O(1)
 */
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}




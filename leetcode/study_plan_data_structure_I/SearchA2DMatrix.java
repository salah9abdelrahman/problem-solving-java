package leetcode.study_plan_data_structure_I;

/*
https://leetcode.com/problems/search-a-2d-matrix/description/?envType=study-plan&id=data-structure-i
 */
public class SearchA2DMatrix {

    /*
    Just less code solution
    Time O(log(n * m))
    Space O(1)
     */
    static public boolean searchMatrix2(int[][] matrix, int target) {
        int min = 0;
        int max = matrix.length * matrix[0].length - 1;
        int n = matrix[0].length - 1;
        while (min <= max) {
            int midIdx = (min + max) / 2;

            int midElement = matrix[midIdx / n][midIdx % n];
            if (midElement > target) {
                max = midIdx - 1;
            } else if (midElement < target) {
                min = midIdx + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    ///////////////////////////////


    /*
    Time O(log(n * m))
    Space O(1)
     */
    static public boolean searchMatrix(int[][] matrix, int target) {
        int arrRange = findArr(matrix, target);
        if (arrRange == -1) {
            return false;
        }
        if (binarySearch(matrix[arrRange], target) == -1) {
            return false;
        } else {
            return true;
        }
    }

    static public int binarySearch(int[] arr, int target) {
        int max = arr.length - 1;
        int min = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (arr[mid] > target) {
                max = mid - 1;
            } else if (arr[mid] < target) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static public int findArr(int[][] arr, int target) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            int[] arrRange = arr[mid];
            if (target < arrRange[0]) {
                max = mid - 1;
            } else if (target > arrRange[arrRange.length - 1]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 9}, {10, 11, 12}, {13, 14, 15}};
        System.out.println(searchMatrix(arr, 8));


    }
}

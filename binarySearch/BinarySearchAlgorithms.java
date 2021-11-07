package binarySearch;

public class BinarySearchAlgorithms {
    static final int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
    static final int[] ARRـREPEATED_APPEARANCE = {1, 2, 3, 3, 3, 5, 6, 7, 8, 9, 10};
    static final int[] ARRـREPEATED_APPEARANCE2 = {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 9, 10};
    static final int[] ARRـREPEATED_APPEARANCE3 = {2, 3, 4, 4};


    public static void main(String[] args) {
        System.out.println(bs(arr, 7));
        System.out.println(bs(arr, 2));
        System.out.println(bs( arr, 1));
        System.out.println(bs( arr, 8));
        System.out.println(bs( arr, 4));
//        System.out.println(bsFirstAppearance(ARRـREPEATED_APPEARANCE, 3));
//        System.out.println(bsFirstAppearance(ARRـREPEATED_APPEARANCE2, 8));
//        System.out.println((ARRـREPEATED_APPEARANCE3, ARRـREPEATED_APPEARANCE3.length,4));
        System.out.println(bsLastAppearance(ARRـREPEATED_APPEARANCE3, 4));
    }

    static int bs(int [] arr, int val) {
        int mid = -1, start = 0, end = arr.length -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] > val) {
                end = mid - 1;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }


    static int bsFirstAppearance(int[] arr, int val) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > val) {
                end = mid - 1;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }

    static int bsLastAppearance(int[] arr, int val) {
        int start = 0, end = arr.length - 1, result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > val) {
                end = mid - 1;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }


}
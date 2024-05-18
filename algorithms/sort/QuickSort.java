package algorithms.sort;

import algorithms.UtilFunctions;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
//        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        quickSort(arr, 0, arr.length);
        UtilFunctions.print(arr);

    }

    static void quickSort(int[] arr, int start, int end) {
        // if it one element array
        if (end - start < 2) {
            return;
        }

        // the correct sorted position of the pivot element
        int pivotIndex = HoarePartitionScheme(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);


    }

    /*
    using the left most element as the pivot
    more efficient than Lomuto partition scheme
    **this causes worst-case behavior on already sorted arrays, which is a rather common use-case.**
     */
    private static int HoarePartitionScheme(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start, j = end;
        while (i < j) {
            //look for elements less than the pivot
            // keep decrementing j until we either find element less than the pivot or j cross i
            while ((i < j) && (arr[--j] >= pivot)) ;
            // making sure that we didn't fall out the empty while because j crossed i
            if (i < j) {
                arr[i] = arr[j];
            }

            //look for elements greater than the pivot
            // keep incrementing i until we either find element greater than the pivot or i cross j
            while ((i < j) && (arr[++i] <= pivot)) ;
            // making sure that we didn't fall out the empty while because i crossed j
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        // here i is equal(crossed) j
        arr[j] = pivot;
        return j;

    }
}

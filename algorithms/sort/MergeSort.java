package algorithms.sort;

import algorithms.UtilFunctions;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        mergeSort(arr, 0, arr.length);
        UtilFunctions.print(arr);

    }


    public static void mergeSort(int[] input, int start, int end) {
        // breaking point for recursion (if the method was calling with one method array)
        if (end - start < 2) {
            return;
        }
        int mid = (start + end) / 2;
        // for the left  array side
        mergeSort(input, start, mid);

        // for the right  array side
        mergeSort(input, mid, end);

        mergeDesc(input, start, mid, end);

    }

    // to merge the two sides
    private static void merge(int[] input, int start, int mid, int end) {
        /*   Optimization:
        (last element in the left partition <= first element in the right partition)
        so to avoid needless sorting
        example {2, 4} {5, 7} ==> if(4 <= 5)=> dont do anything
*/
        if (input[mid - 1] <= input[mid]) {
            return;
        }

        // to loop over the left array
        int i = start;

        // to loop over the right array
        int j = mid;

        // to keep track where we are in the te temp array
        int tempIndex = 0;

        int[] temp = new int[end - start];

        // while we didn't finish traversing  any of the array sides
        while ((i < mid) && (j < end)) {
            // (=) to make the algorithm stable
            temp[tempIndex++] = (input[i] <= input[j]) ? input[i++] : input[j++];

        }

        /* Optimization
        if we have remaining elements in the left partition: we will copy them into the temp array
         if we have remaining elements in the right partition: we will not copying them int the temp array
          because these elements are greater  than the elements in the temp array so we will avoid
           the needless work by overriding their places
          example on remaining right elements: {2, 4} {3, 7} ==> {2, 3, 4} 7's place will not change.
          example on remaining left elements: {2, 9} {3, 7} ==> {2, 3, 7 } & coping the remaining 9.
         */

        //copying remaining left elements (we copying over in the array not in the temp array)
        // mid - 1: tells us the numbers of elements we didn't copy over into the temp array from the left partition
        //length: how many elements to copy?
        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        //copy from the temp array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    // to merge the two sides
    private static void mergeDesc(int[] input, int start, int mid, int end) {
        /*   Optimization:
        (last element in the left partition <= first element in the right partition)
        so to avoid needless sorting
        example {2, 4} {5, 7} ==> if(4 <= 5)=> dont do anything
*/
        if (input[mid - 1] >= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while ((i < mid) && (j < end)) {
            temp[tempIndex++] = (input[i] >= input[j]) ? input[i++] : input[j++];

        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}

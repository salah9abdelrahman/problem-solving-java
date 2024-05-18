package algorithms.sort;

import algorithms.UtilFunctions;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        iterationInsertionSort(arr);
//        recursiveInsertionSort(arr, 1);
//        recursiveInsertionSort2(arr, arr.length);

        UtilFunctions.print(arr);

    }


    static void iterationInsertionSort(int[] arr) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            /*
            i > 0: we haven't hit the first of the array
            arr[i-1] > newElement: keep traversing as long as the element we are looking at in
            traversing is greater than the new element we want to insert
             */
            int i;
            for (i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = newElement;
        }
    }

    static void recursiveInsertionSort(int[] input, int firstUnsortedIndex) {
        if (firstUnsortedIndex >= input.length) {
            return;
        }

        int newElement = input[firstUnsortedIndex];

        int i;
        for (i = firstUnsortedIndex; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;
        ++firstUnsortedIndex;
        recursiveInsertionSort(input, firstUnsortedIndex);
    }


    static void recursiveInsertionSort2(int[] input, int numOfItems) {
        if (numOfItems == 1) {
            return;
        }
        recursiveInsertionSort2(input, numOfItems - 1);

        int newElement = input[numOfItems -1];
        int i;

        for (i = numOfItems -1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;
    }

}

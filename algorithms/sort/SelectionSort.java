package algorithms.sort;

import algorithms.UtilFunctions;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }
            UtilFunctions.swap(arr, largest, lastUnsortedIndex);

        }

        UtilFunctions.print(arr);
    }
}

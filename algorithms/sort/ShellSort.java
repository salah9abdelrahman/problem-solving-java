package algorithms.sort;

import algorithms.UtilFunctions;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        //initialize the gab and reduce it
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;

                //if j < gap: means hit the front of array
                while ((j >= gap) && (arr[j - gap] > newElement)) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = newElement;
            }
        }

        UtilFunctions.print(arr);
    }
}

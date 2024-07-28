package algorithms.sort;

import algorithms.UtilFunctions;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        countingSort(arr);
        UtilFunctions.print(arr);
    }

    static void countingSort(int[] input) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // finding min & max
        for(int i: input){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int[] countArray = new int[(max - min + 1)];
//

        for (int i = 0; i < input.length; i++) {
            // min: to start from index 0
            countArray[input[i] - min]++;
        }

        //index to write to input array
        int j = 0;

        // traverse the counting array
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}

package algorithms.sort;

import static algorithms.UtilFunctions.swap;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }
            }
        }


    }

}

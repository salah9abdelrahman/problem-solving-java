package recursion.recursion.recursion;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(data, start, mid);
        sort(data, mid + 1, end);
        merge(data, start, mid, end);
    }

    private static void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }

        while (j <= end) {
            temp[k++] = data[j++];
        }

        for (i = start; i <= end; i++) {
            data[i] = temp[i - start];
        }

    }

    public static void main(String[] args) {
        int[] data = new int[]{3, 1, 9, 7, 4, 2, 5, 8};
        sort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
}

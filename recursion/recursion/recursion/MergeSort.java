package recursion.recursion.recursion;

public class MergeSort {

    public static void sort(int[] data, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        sort(data, start, mid);
        sort(data, mid+1, end);
        merge(data, start, mid, end);
    }

    private static void merge(int[] data, int start, int mid, int end) {


    }

    public static void main(String[] args) {

    }
}

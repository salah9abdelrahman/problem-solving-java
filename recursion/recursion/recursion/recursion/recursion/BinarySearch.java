package recursion.recursion.recursion.recursion.recursion;

public class BinarySearch {

    public static int search(int[] arr, int left, int right, int num) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;

        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] < num) {
            return search(arr, mid + 1, right, num);
        }
        return search(arr, left, mid - 1, num);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6, 7, 9, 16};
        System.out.println(search(arr, 0, arr.length, 2));
    }
}

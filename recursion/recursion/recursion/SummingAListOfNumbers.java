package recursion.recursion.recursion;

public class SummingAListOfNumbers {

  // Time O(n), Space O(n)
    static public int sum(int[] list, int index) {
        if (list.length == index) {
            return 0;
        }

        return list[index] + sum(list, index + 1);

    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5, 6};
        int sum = sum(list, 0);
        System.out.println(sum);
    }

}

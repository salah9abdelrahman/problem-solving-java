package recursion.recursion.recursion;

public class SumOfNaturalNumbers {
    public static int sum(int num) {
        if (num <= 1) {
            return num;
        }
        return num + sum(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
    }
}

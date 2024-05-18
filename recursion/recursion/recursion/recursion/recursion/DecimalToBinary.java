package recursion.recursion.recursion.recursion.recursion;

public class DecimalToBinary {

    public static String decimalToBinary(int num, StringBuilder result) {
        if (num == 0) {
            return result.toString();
        }
        result.insert(0, num % 2);
        return decimalToBinary(num / 2, result);
    }
    //11101000

    public static void main(String[] args) {

      String  res = decimalToBinary(232, new StringBuilder());

        System.out.println(res);
    }
}

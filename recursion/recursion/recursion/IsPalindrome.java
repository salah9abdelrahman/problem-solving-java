package recursion.recursion.recursion;

public class IsPalindrome {

    public static boolean isPalindrome(String input) {
        //  base case
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }
        // work toward the base case
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
        // additional base case
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("salah"));
    }
}

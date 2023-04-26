package patterns.two_pointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abcba"));
        System.out.println(validPalindrome("abcca"));
    }

  static   boolean validPalindrome(String s){
        for (int i = 0, j = s.length() -1; i < s.length() /2; i++, j--) {
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

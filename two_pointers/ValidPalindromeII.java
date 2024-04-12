package two_pointers;

public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ABCEBA"));
        System.out.println(isPalindrome("madame"));
        System.out.println(isPalindrome("dead"));
        System.out.println(isPalindrome("abca"));
        System.out.println(isPalindrome("tebbem"));
        System.out.println(isPalindrome("eeccccbebaeeabebccceea"));
    }

    /*
    Time O(n)
     */
    public static boolean isPalindrome(String s) {
        int skips = 0;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (skips == 2) {
                return false;
            }
            if (s.charAt(left) != s.charAt(right)) {
                skips++;
                if (s.charAt(left) == s.charAt(right - 1)) {
                    right--;
                } else if (s.charAt(left + 1) == s.charAt(right)) {
                    left++;
                } else {
                    return false;
                }
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}

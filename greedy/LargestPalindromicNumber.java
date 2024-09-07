// https://leetcode.com/problems/largest-palindromic-number/description/
package greedy;

/**
 * @time o(n)
 * @space o(n)
 */
class LargestPalindromicSolution {
    public String largestPalindromic(String num) {

        int[] arr = new int[10];

        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        int bigestOddOcurr = -1;
        for (int i = 9; i > 0; i--) {

            if(arr[i] == 0){
                continue;
            }

            int freq = arr[i];

            if (freq % 2 != 0 && bigestOddOcurr == -1) {
                bigestOddOcurr = i;
            }

            addToString(arr, sb, i);
        }

        if (bigestOddOcurr != -1) {
            sb.insert(sb.length() / 2, bigestOddOcurr);
        }

        if (sb.length() > 1 && arr[0] > 0) {
            addToString(arr, sb, 0);
        }

        if(sb.length() % 2 == 0 && bigestOddOcurr == -1 && arr[0] %2 != 0){
            sb.insert(sb.length()/2, 0);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }

    private void addToString(int[] arr, StringBuilder sb, int i) {
        for (int j = 0; j < arr[i] / 2; j++) {
            sb.insert(sb.length() / 2, i);
            sb.insert(sb.length() / 2 + 1, i);
        }
    }

}


public class LargestPalindromicNumber {
    public static void main(String[] args) {
//        System.out.println(new Solution().largestPalindromic("444947137"));
//        System.out.println(new Solution().largestPalindromic("00001105"));
        System.out.println(new LargestPalindromicSolution().largestPalindromic("00011"));
//        System.out.println(new Solution().largestPalindromic("0001"));
    }
}
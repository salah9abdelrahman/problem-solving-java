package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String[] str1 = {"abcdebdde", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta", "cnhczmccqouqadqtmjjzl"};
        String[] str2 = {"bde", "kzed", "css", "la", "ab", "cm"};

        System.out.println(minWindow(str1[0], str2[0]));

    }

    /*
    Time O(n * m)
    Space O(1)
     */
    public static String minWindow(String s1, String s2) {
        int sizeStr1 = s1.length();
        int sizeStr2 = s2.length();
        float length = Float.POSITIVE_INFINITY;
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0, end = 0;
        String minSubsequence = "";
        while (indexS1 < sizeStr1) {
            if (s1.charAt(indexS1) == s2.charAt(indexS2)) {
                indexS2 += 1;
                if (indexS2 == sizeStr2) {
                    start = indexS1;
                    end = indexS1;
                    indexS2 -= 1;
                    /*
                     * here is the sliding window
                     * the benefit is to reduce the inner loop number when we now that some characters are useless
                     * example: s1 = 2000 * a + 20 * b + 500 * c
                     *          s2 = abbc
                     * here the inner loop won't loop over all the a except the last one & only the first c letter
                     */
                    while (indexS2 >= 0) {
                        if (s1.charAt(start) == s2.charAt(indexS2)) {
                            indexS2 -= 1;
                        }
                        start -= 1;
                    }
                    start += 1;
                    if ((end - start + 1) < length) {
                        length = end - start + 1;
                        minSubsequence = s1.substring(start, end + 1);
                    }
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            indexS1 += 1;
        }
        return minSubsequence;
    }
}

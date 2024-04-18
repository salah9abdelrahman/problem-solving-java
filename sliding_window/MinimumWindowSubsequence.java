package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String[] str1 = { "abcdebdde", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta", "cnhczmccqouqadqtmjjzl" };
        String[] str2 = { "bde", "kzed", "css", "la", "ab", "cm" };

        System.out.println(minWindow(str1[5], str2[5]));

    }

    public static String minWindow(String s1, String s2) {
        int idx1 = 0, idx2 = 0;
        int startSeqIndx = 0, endSeqIndx = 0, minLen = Integer.MAX_VALUE;
        int solIdx1 = 0, solIdx2 = 0;
        while (idx1 < s1.length()) {
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                if (idx2 == 0) {
                    startSeqIndx = idx1;
                }
                idx2++;
                if (idx2 == s2.length()) {
                    endSeqIndx = idx1;
                    if (endSeqIndx - startSeqIndx < minLen) {
                        solIdx1 = startSeqIndx;
                        solIdx2 = endSeqIndx;
                        minLen = solIdx2 - solIdx1;
                    }
                    idx2 = 0;
                    idx1 = startSeqIndx;
                }
            }
            idx1++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s1.substring(solIdx1, solIdx2 + 1);
    }
}

package sliding_window;

import java.util.HashMap;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    /*
    Time O(n)
     */
    static public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int start = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charIdx = new HashMap<>();
        int end;
        for (end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (!charIdx.containsKey(c)) {
                charIdx.put(c, end);
            } else {
                if (charIdx.get(c) >= start) {
                    if (end - start > maxLen) {
                        maxLen = end - start;
                    }
                    start = charIdx.get(c) + 1;
                }
                charIdx.replace(c, end);
            }
        }
        if (maxLen < end - start) {
            maxLen = end - start;
        }
        return maxLen;
    }
}


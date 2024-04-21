package sliding_window;

import java.util.HashMap;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }

    static public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int start = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charIdx = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (!charIdx.containsKey(c)) {
                charIdx.put(c, end);
                if (end - start + 1 > maxLen) {
                    maxLen = end - start + 1;
                }
            } else {
                start = charIdx.get(c) + 1;
                charIdx.clear();
                for (int i = start; i <= end; i++) {
                    charIdx.put(s.charAt(i), i);
                }
            }
        }
        return maxLen ;
    }
}

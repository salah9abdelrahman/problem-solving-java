package sliding_window;

import java.util.*;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        characterReplacement("aabccbb", 2);
    }

    /*
    Time O(n)
    Space O(1)
     */
    static public int characterReplacement(String s, int k) {
        int stringLength = s.length();
        int lengthOfMaxSubstring = 0;
        int start = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int mostFreqChar = 0;

        for (int end = 0; end < stringLength; end++) {
            char currentChar = s.charAt(end);
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);
            mostFreqChar = Math.max(mostFreqChar, charFreq.get(currentChar));

            if (end - start + 1 - mostFreqChar > k) {
                charFreq.put(s.charAt(start), charFreq.get(s.charAt(start)) - 1);
                start++;
            }

            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);

        }
        return lengthOfMaxSubstring;
    }
}

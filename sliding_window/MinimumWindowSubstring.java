package sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("acbbaca", "aba"));
    }

    /*
    Time: O(S + T)
    Space O(S + T)
     */

    static public String minWindow(String s, String t) {
        if (s.equals("") || t.equals("")) {
            return "";
        }
        HashMap<Character, Integer> freqHashMapForT = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        int[] sol = new int[2];

        for (int i = 0; i < t.length(); i++) {
            freqHashMapForT.put(t.charAt(i), freqHashMapForT.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> freqHashMapForS = new HashMap<>();

        int start = 0;

        int required = freqHashMapForT.size();
        int current = 0;
        int end;
        for (end = 0; end < s.length(); end++) {
            if (freqHashMapForT.containsKey(s.charAt(end))) {
                freqHashMapForS.put(s.charAt(end), freqHashMapForS.getOrDefault(s.charAt(end), 0) + 1);
                if (freqHashMapForT.get(s.charAt(end)).intValue() == freqHashMapForS.get(s.charAt(end)).intValue()) {
                    current++;
                }
            }


            while (start <= end && current == required) {
                if (end - start < minWindow) {
                    minWindow = end - start;
                    sol[0] = start;
                    sol[1] = end;
                }
                if (freqHashMapForT.containsKey(s.charAt(start))) {
                    freqHashMapForS.put(s.charAt(start), freqHashMapForS.get(s.charAt(start)) - 1);
                    if (freqHashMapForT.get(s.charAt(start)) > freqHashMapForS.get(s.charAt(start))) {
                        current--;
                    }
                }
                start++;
            }

        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(sol[0], sol[1] + 1);
    }


    ////////////////////

    public String minWindow_leetCode(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> freqHashMapForT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            freqHashMapForT.put(t.charAt(i), freqHashMapForT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = freqHashMapForT.size();

        // Left and Right pointer
        int start = 0, end = 0;

        int current = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> freqHashMapForS = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (end < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(end);
            freqHashMapForS.put(c, freqHashMapForS.getOrDefault(c, 0) + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (freqHashMapForT.containsKey(c) && freqHashMapForS.get(c) == freqHashMapForT.get(c)) {
                current++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (start <= end && current == required) {
                c = s.charAt(start);
                // Save the smallest window until now.
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                freqHashMapForS.put(c, freqHashMapForS.get(c) - 1);
                if (freqHashMapForT.containsKey(c) && freqHashMapForS.get(c).intValue() < freqHashMapForT.get(c).intValue()) {
                    current--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                start++;
            }

            // Keep expanding the window once we are done contracting.
            end++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

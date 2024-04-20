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

    static public String minWindow(String s, String t) {
        HashMap<Character, Integer> freqHashMapForT = new HashMap<>();
        int minWindow = Integer.MAX_VALUE;
        int[] sol = new int[2];

        for (int i = 0; i < t.length(); i++) {
            freqHashMapForT.put(t.charAt(i), freqHashMapForT.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> freqHashMapForS = new HashMap<>();

        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if(freqHashMapForT.containsKey(s.charAt(end))){
                freqHashMapForS.put(s.charAt(end), freqHashMapForS.getOrDefault(s.charAt(end), 0) + 1);
            }
            while (validWindowFound(freqHashMapForT, freqHashMapForS)) {
                if (end - start < minWindow) {
                    minWindow = end - start;
                    sol[0] = start;
                    sol[1] = end;
                }
                if(freqHashMapForT.containsKey(s.charAt(start))){
                freqHashMapForS.put(s.charAt(start), freqHashMapForS.get(s.charAt(start)) - 1);
                }
                start++;
            }

        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(sol[0], sol[1] +1);
    }

    private static boolean validWindowFound(HashMap<Character, Integer> freqHashMapForT,
            HashMap<Character, Integer> freqHashMapForS) {
        for (Map.Entry<Character, Integer> entry : freqHashMapForT.entrySet()) {
            if (freqHashMapForS.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }


    ////////////////////

    public String minWindow_leetCode(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();

        // Left and Right pointer
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        // ans list of the form (window length, left, right)
        int[] ans = { -1, 0, 0 };

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }

            // Keep expanding the window once we are done contracting.
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    }
}

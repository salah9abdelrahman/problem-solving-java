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
            freqHashMapForS.put(s.charAt(end), freqHashMapForS.getOrDefault(s.charAt(end), 0) + 1);

            while (validWindowFound(freqHashMapForT, freqHashMapForS)) {
                if (end - start < minWindow) {
                    minWindow = end - start;
                    sol[0] = start;
                    sol[1] = end;
                }
                freqHashMapForS.put(s.charAt(start), freqHashMapForS.get(s.charAt(start)) - 1);
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
}

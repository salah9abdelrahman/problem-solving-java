//https://leetcode.com/problems/reorganize-string/description/
package top_k_elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("abbabbaaab"));
    }

    /*
    Time: O(n log n)
     */
    static public String reorganizeString(String s) {
        HashMap<Character, Integer> count = new HashMap<>(s.length());
        for (Character c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(s.length(), (a, b) -> b.getValue() - a.getValue() == 0 ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        heap.addAll(count.entrySet());

        if (heap.peek().getValue() > s.length() - heap.peek().getValue() + 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder(s.length());

        while (!heap.isEmpty()) {
            Map.Entry<Character, Integer> e1 = heap.poll();
            sb.append(e1.getKey());
            e1.setValue(e1.getValue() - 1);
            if (!heap.isEmpty()) {
                Map.Entry<Character, Integer> e2 = heap.poll();
                sb.append(e2.getKey());
                e2.setValue(e2.getValue() - 1);
                if (e2.getValue() > 0) {
                    heap.add(e2);
                }
            }
            if (e1.getValue() > 0) {
                heap.add(e1);
            }
        }
        return sb.toString();
    }
}

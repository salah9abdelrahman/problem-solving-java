//https://leetcode.com/problems/sort-characters-by-frequency/description/
package top_k_elements;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
//        System.out.println(frequencySort("bubbule"));
        System.out.println(frequencySort_bucketSort("bubbule"));
    }

    /*
    Time: o(n log n)
    Space o(n)
     */
    static public String frequencySort(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(counts.keySet());
        characters.sort((a, b) -> counts.get(b) - counts.get(a));


        StringBuilder output = new StringBuilder();

        for (char c : characters) {
            output.append(String.valueOf(c).repeat(Math.max(0, counts.get(c))));
        }

        return output.toString();
    }

    /*
    Time o(n)
    Space o(n)
     */
    static public String frequencySort_bucketSort(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int maxFreq = Collections.max(counts.values());

        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Character key : counts.keySet()) {
            buckets.get(counts.get(key)).add(key);
        }

        StringBuilder output = new StringBuilder();

        for (int i = buckets.size() - 1; i > 0; i--) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                output.append(String.valueOf(buckets.get(i).get(j)).repeat(i));
            }
        }

        return output.toString();
    }
}

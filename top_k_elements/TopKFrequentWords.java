// 692. Top K Frequent Words https://leetcode.com/problems/top-k-frequent-words/description/
package top_k_elements;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    /**
     * Time O(n log k)
     * Space O(k)
     */

    static public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }


        PriorityQueue<String> heap = new PriorityQueue<>(k, (a, b) ->
        {
            if (Objects.equals(count.get(b), count.get(a))) {
                return b.compareTo(a);
            }
            return count.get(a) - count.get(b);
        });

        int i = 0;
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            if (i < k) {
                heap.add(e.getKey());
                i++;
            } else if (e.getValue() > count.get(heap.peek()) || (Objects.equals(e.getValue(), count.get(heap.peek())) && e.getKey().compareTo(heap.peek()) < 0)) {
                heap.poll();
                heap.add(e.getKey());
            }
        }

        return heap.stream().sorted((a, b) ->
                Objects.equals(count.get(a), count.get(b)) ? a.compareTo(b) : count.get(b) - count.get(a)).toList();
    }
}

// 692. Top K Frequent Words https://leetcode.com/problems/top-k-frequent-words/description/
package top_k_elements;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new HeapSolution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new BucketSortWithTrieSolution().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

}

class HeapSolution {
    /**
     * Time O(n log k)
     * Space O(k)
     */
    public List<String> topKFrequent(String[] words, int k) {
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

class BucketSortWithTrieSolution {
    private int k;
    private List<String> res;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    public List<String> topKFrequent(String[] words, int k) {
        this.k = k;
        res = new ArrayList<>();
        int n = words.length;
        TrieNode[] bucket = new TrieNode[n + 1];
        Map<String, Integer> cnt = new HashMap<>();

        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        for (var entry : cnt.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new TrieNode();
            }
            addWord(bucket[entry.getValue()], entry.getKey());
        }

        for (int i = n; i > 0; i--) {
            if (bucket[i] != null) {
                getWords(bucket[i], "");
            }
            if (this.k == 0) {
                break;
            }
        }
        return res;

    }

    private void addWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    private void getWords(TrieNode root, String prefix) {
        if (k == 0) {
            return;
        }
        if (root.isWord) {
            k--;
            res.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], prefix + (char) (i + 'a'));
            }
        }
    }
}
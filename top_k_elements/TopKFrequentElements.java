// 347. Top K Frequent Elements https://leetcode.com/problems/top-k-frequent-elements/description/
package top_k_elements;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    /**
     * bucket sort
     * Time O(n)
     * space O(k)
     */
    static public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            int freq = count.getOrDefault(num, 0) + 1;
            count.put(num, freq);
            max = Math.max(max, freq);
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int[] output = new int[k];

        int x = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                if (k == x) {
                    return output;
                }
                output[x++] = buckets.get(i).get(j);
            }

        }

        return output;
    }
}

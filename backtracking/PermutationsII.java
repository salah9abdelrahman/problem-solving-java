// https://leetcode.com/problems/permutations-ii/description/
package backtracking;

import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(new PermutationsIISolution().permuteUnique(new int[]{1, 1, 2}));
    }
}

class PermutationsIISolution {
    /**
     * @time O(n * n!)
     * @space O(n)
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        backtracking(counter, result, new LinkedList<>(), nums.length);
        return result;
    }

    private void backtracking(HashMap<Integer, Integer> counter, List<List<Integer>> result, LinkedList<Integer> curr, int n) {
        if (curr.size() == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            curr.addLast(num);
            counter.put(num, count - 1);

            backtracking(counter, result, curr, n);

            curr.removeLast();
            counter.put(num, count);

        }
    }

}
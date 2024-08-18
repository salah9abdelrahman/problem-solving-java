// https://leetcode.com/problems/permutations-ii/description/
package backtracking;

import java.util.*;

public class PermutationsII {
    public static void main(String[] args) {
        System.out.println(new PermutationsIIBacktrackingSolution().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new PermutationsIIBacktrackingSolution2().permuteUnique(new int[]{1, 1, 2}));
    }
}

class PermutationsIIBacktrackingSolution {
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

class PermutationsIIBacktrackingSolution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new boolean[nums.length + 1], result, new LinkedList<>(), nums.length);
        return result;
    }

    private void backtracking(int[] nums, boolean[] visited, List<List<Integer>> result, LinkedList<Integer> curr,
                              int n) {
        if (curr.size() == n) {
            result.add(new ArrayList<>(curr));
            return;
        }
        HashSet<Integer> uniqueVisited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || uniqueVisited.contains(nums[i]))
                continue;

            curr.addLast(nums[i]);
            visited[i] = true;
            uniqueVisited.add(nums[i]);

            backtracking(nums, visited, result, curr, n);

            curr.removeLast();
            visited[i] = false;

        }
    }
}
// https://leetcode.com/problems/permutations/description/
package subsets;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new PermutationsSolution().permute(new int[]{1, 2, 3}));
        System.out.println(new PermutationBacktrackingSolution().permute(new int[]{1, 2, 3}));
    }
}

class PermutationBacktrackingSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(nums, output, new ArrayList<>(), new HashSet<>());
        return output;

    }
    /**
     * Time O(n * n!) first n for copying curr array to output
     * space O(n)
     */
    private void backtrack(int[] nums, List<List<Integer>> output, ArrayList<Integer> curr, Set<Integer> visited) {
        if (curr.size() == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                curr.add(nums[i]);
                visited.add(nums[i]);

                backtrack(nums, output, curr, visited);

                curr.remove(curr.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }
}


class PermutationsSolution {
    /**
     * Time O(N * N!)
     * Space O(N)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permuteGenerator(nums, output, 0);
        return output;
    }

    private void permuteGenerator(int[] nums, List<List<Integer>> output, int currentIndex) {
        if (currentIndex == nums.length - 1) {
            output.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            int[] numsSwapped = swap(nums, i, currentIndex);
            permuteGenerator(numsSwapped, output, currentIndex + 1);
        }
    }

    private int[] swap(int[] nums, int i, int j) {
        int[] arrSwap = nums.clone();
        int temp = arrSwap[i];
        arrSwap[i] = arrSwap[j];
        arrSwap[j] = temp;
        return arrSwap;
    }
}

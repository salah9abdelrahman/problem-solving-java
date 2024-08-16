// https://leetcode.com/problems/subsets/description/
package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new SubsetsCascadingSolution().subsets(new int[]{1, 2, 3}));
        System.out.println(new SubsetsBacktrackingSolution().subsets(new int[]{1, 2, 3}));
    }
}

class SubsetsCascadingSolution {
    /**
     * Time O(N * (2 ** N))
     * Space O(N * (2 ** N))
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int num : nums) {
            int s = output.size();
            for (int j = 0; j < s; j++) {
                List<Integer> existingSubset = output.get(j);
                List<Integer> newSubset = new ArrayList<>(existingSubset);
                newSubset.add(num);
                output.add(newSubset);
            }
        }
        return output;
    }
}

class SubsetsBacktrackingSolution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++) {
            backtrack(output, nums, new ArrayList<Integer>(), 0, k);
        }
        return output;
    }

    public void backtrack(List<List<Integer>> output, int[] nums, ArrayList<Integer> curr, int first, int k) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }
        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(output, nums, curr, i + 1, k);
            curr.remove(curr.size() - 1);
        }

    }
}

// https://leetcode.com/problems/subsets/description/
package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new SubsetsSolution().subsets(new int[]{1, 2, 3}));
    }
}

class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int s = output.size();
            for (int j = 0; j < s; j++) {
                List<Integer> existingSubset = output.get(j);
                List<Integer> newSubset = new ArrayList<>(existingSubset);
                newSubset.add(nums[i]);
                output.add(newSubset);
            }
        }
        return output;
    }
}

// https://leetcode.com/problems/permutations/description/
package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new PermutationsSolution().permute(new int[]{1, 2, 3}));
    }
}

class PermutationsSolution {
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
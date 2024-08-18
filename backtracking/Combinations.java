// https://leetcode.com/problems/combinations/description/
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new CombinationsSolution().combine(4, 2));
    }
}

class CombinationsSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, result, new ArrayList<Integer>(), 1);
        return result;
    }

    private void backtracking(int n, int k, List<List<Integer>> result, List<Integer> curr, int j) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = j; i <= n; i++) {
            curr.add(i);

            backtracking(n, k, result, curr, i + 1);

            curr.remove(curr.size() - 1);

        }
    }

}
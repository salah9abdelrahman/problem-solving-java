// https://leetcode.com/problems/generate-parentheses/description/
package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesesSolution().generateParenthesis(3));
    }
}

class GenerateParenthesesSolution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtracking(n, new StringBuilder(), result, 0, 0);

        return result;
    }

    private void backtracking(int n, StringBuilder curr, List<String> result, int leftCount, int rightCount) {
        if (curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }
        if (leftCount < n) {
            curr.append('(');
            backtracking(n, curr, result, leftCount + 1, rightCount);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (leftCount > rightCount) {
            curr.append(')');
            backtracking(n, curr, result, leftCount, rightCount + 1);
            curr.deleteCharAt(curr.length() - 1);
        }

    }
}
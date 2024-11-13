// https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/
package backtracking;

import java.util.ArrayList;
import java.util.List;


class Solution {
    int[][] POSSIBLE_MOVES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROW_NUM;
    int COL_NUM;
    int minMoves = Integer.MAX_VALUE;

    /**
     * @time O(1) because O(n^m) which is O(9^9)
     */
    public int minimumMoves(int[][] grid) {
        ROW_NUM = grid.length;
        COL_NUM = grid[0].length;
        List<int[]> zeros = new ArrayList<>();
        List<int[]> extras = new ArrayList<>();
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                if (grid[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                } else if (grid[i][j] > 1) {
                    extras.add(new int[]{i, j, grid[i][j] - 1});
                }
            }
        }

        if (zeros.isEmpty()) {
            return 0;
        }


        backtrack(zeros, extras, 0, 0);

        return minMoves;
    }

    private void backtrack(List<int[]> zeros, List<int[]> extras, int i, int count) {
        if (i == zeros.size()) {
            minMoves = Math.min(minMoves, count);
            return;
        }

        for (int k = 0; k < extras.size(); k++) {
            if (extras.get(k)[2] != 0) {
                extras.get(k)[2]--;

                backtrack(zeros, extras, i + 1,
                        Math.abs(extras.get(k)[0] - zeros.get(i)[0]) + Math.abs(extras.get(k)[1] - zeros.get(i)[1]) + count);

                extras.get(k)[2]++;
            }
        }

    }

}

public class MinimumMovesToSpreadStonesOverGrid {
    public static void main(String[] args) {
        System.out.println(new Solution().minimumMoves(new int[][]{
                {3, 2, 0},
                {0, 1, 0},
                {0, 3, 0},
        }));
    }
}

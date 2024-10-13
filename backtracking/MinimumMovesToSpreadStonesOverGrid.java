// https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/
package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int[][] POSSIBLE_MOVES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROW_NUM;
    int COL_NUM;
    int ans = Integer.MAX_VALUE;

    public int minimumMoves(int[][] grid) {
        ROW_NUM = grid.length;
        COL_NUM = grid[0].length;
        List<int[]> zeros = new ArrayList<>();
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                if (grid[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < zeros.size(); i++) {
            backtrack(grid, zeros, 0, Integer.MAX_VALUE);
        }

    }

    private void backtrack(int[][] grid, List<int[]> zeros, int i, int result) {
        if (result > ans) {
            return;
        }
        if (zeros.size() == i) {
            ans = result;
            return;
        }


        for (int j = 0; j < zeros.size(); j++) {
            if (i == j) {
                continue;
            }

            int moves = bfs(grid,zeros[0], zeros[1]);
        }

    }


    private int bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[ROW_NUM][COL_NUM];

        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            visited[node[0]][node[1]] = true;
            if (grid[node[0]][node[1]] > 1) {
                grid[i][j] = 1;
                grid[node[0]][node[1]]--;
                return Math.abs(i - node[0]) + Math.abs(j - node[1]);

            }
            for (int k = 0; k < POSSIBLE_MOVES.length; k++) {
                if (isValid(node[0] + POSSIBLE_MOVES[k][0], node[1] + POSSIBLE_MOVES[k][1]) &&
                        !visited[node[0] + POSSIBLE_MOVES[k][0]][node[1] + POSSIBLE_MOVES[k][1]]) {
                    q.add(new int[]{node[0] + POSSIBLE_MOVES[k][0], node[1] + POSSIBLE_MOVES[k][1]});
                }

            }
        }
        return -1;
    }

    private boolean isValid(int r, int col) {
        return r >= 0 && r < ROW_NUM && col >= 0 && col < COL_NUM;
    }

    private int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[3][3];
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
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

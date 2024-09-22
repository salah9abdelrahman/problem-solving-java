// https://leetcode.com/problems/flood-fill/description/
package backtracking;

import java.util.Arrays;

/**
 * @time O(n * m)
 * @space O(n)
 */
class FloodFill_backtracking_solution {
    int[][] POSSIBLE_MOVES = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROW_NUM;
    int COL_NUM;
    int START_COLOR;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ROW_NUM = image.length;
        COL_NUM = image[0].length;
        START_COLOR = image[sr][sc];

        if (image[sr][sc] != color) {
            dfs(image, sr, sc, color);
        }

        return image;

    }

    private void dfs(int[][] image, int r, int c, int color) {

        if (image[r][c] == START_COLOR) {
            image[r][c] = color;

            for (int i = 0; i < POSSIBLE_MOVES.length; i++) {
                if (isValid(r + POSSIBLE_MOVES[i][0], c + POSSIBLE_MOVES[i][1])
                        && image[r + POSSIBLE_MOVES[i][0]][c + POSSIBLE_MOVES[i][1]] != color) {
                    dfs(image, r + POSSIBLE_MOVES[i][0], c + POSSIBLE_MOVES[i][1], color);

                }
            }
        }

    }

    private boolean isValid(int r, int col) {
        return r >= 0 && r < ROW_NUM && col >= 0 && col < COL_NUM;
    }
}


public class FloodFill {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FloodFill_backtracking_solution().floodFill(
                new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                },
                1, 1, 2
        )));
    }
}

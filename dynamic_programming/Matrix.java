//https://leetcode.com/problems/01-matrix/description/

package dynamic_programming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(Arrays.deepToString(new Matrix_BFS_Solution().updateMatrix(mat)));
    }
}

/*
    @time: O(m*n)
    @space O(m*n)
 */
class Matrix_BFS_Solution {
    static final int[][] VALID_MOVES = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m;
    int n;


    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();


        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    queue.add(new Node(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int[] move : VALID_MOVES) {
                int nextRow = current.r + move[0], nextCol = current.c + move[1];

                if (valid(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    queue.add(new Node(nextRow, nextCol, current.steps + 1));
                    visited[nextRow][nextCol] = true;
                    mat[nextRow][nextCol] = current.steps + 1;

                }
            }
        }


        return mat;
    }

    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }

}

class Node {
    int r;
    int c;
    int steps;

    public Node(int r, int c, int steps) {
        this.r = r;
        this.c = c;
        this.steps = steps;
    }

    @Override
   public String toString(){
        return "row: " + r + " col: " + c + " steps: " + steps;
    }
}
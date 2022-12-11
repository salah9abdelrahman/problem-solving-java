package leetcode;

import java.util.Arrays;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{3, 7, 2}, {4, 6, 1}, {2, 10, 15}, {8, 1, 13}}, 6, 2)));
        System.out.println(Arrays.deepToString(matrixReshape(new int[][]{{1, 2, 3, 4}}, 2, 2)));
    }

    /*
    Time: O(r * c)
    Space O(r * c)
     */
    static public int[][] matrixReshape(int[][] mat, int r, int c) {
        int oldC = mat[0].length;
        int oldR = mat.length;

        if (r * c != oldR * oldC) {
            return mat;
        }

        int k = 0;

        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int r1 = k / oldC;
                int c1 = k % oldC;
                res[i][j] = mat[r1][c1];
                k++;
            }
        }
        return res;
    }
}

package leetcode.study_plan_data_structure_I;

import java.util.HashSet;

public class ValidSudoku {

    /*
    runtime O(N ^ 2)
    space O(N ^ 2)
     */
    static boolean isValidSudoku_hashset(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] clos = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            clos[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];
                if (val == '.') {
                    continue;
                }
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                if (clos[c].contains(val)) {
                    return false;
                }
                clos[c].add(val);

                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }

    /*
 runtime O(N ^ 2)
 space O(N ^ 2)
  */
    static boolean isValidSudoku_arrays(char[][] board) {
        int N = 9;

        // Use an array to record the status
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // Check the row
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }
        }
        return true;
    }
}
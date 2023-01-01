package leetcode;

import java.util.HashSet;

public class ValidSudoku {

    /*
    runtime O(N ^ 2)
    space O(N ^ 2)
     */
    static boolean isValidSudoku(char[][] board) {
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
}
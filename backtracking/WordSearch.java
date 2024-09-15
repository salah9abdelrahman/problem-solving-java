package backtracking;

/**
 * @time O(N * 3 ^ L)
 * where N = Number of cells, L = len of the word.
 * 3? the directions, we won't count the direction we came from it.
 * @space O(L)
 * why? the recursion call stack
 */
class WordSearch_backtracking_solution {
    int[][] VALID_MOVES = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROW_NUM;
    int COL_NUM;

    public boolean exist(char[][] board, String word) {
        ROW_NUM = board.length;
        COL_NUM = board[0].length;
        for (int r = 0; r < ROW_NUM; r++) {
            for (int c = 0; c < COL_NUM; c++) {
                if (backtrack(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean backtrack(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (!isValidMove(r, c) || board[r][c] != word.charAt(idx)) {
            return false;
        }

        boolean ret = false;
        board[r][c] = '#';
        for (int[] validMove : VALID_MOVES) {
            ret = backtrack(board, r + validMove[0], c + validMove[1], word, idx + 1);
            if (ret) {
                break;
            }

        }
        board[r][c] = word.charAt(idx);
        return ret;
    }

    private boolean isValidMove(int r, int c) {
        return r >= 0 && r < ROW_NUM && c >= 0 && c < COL_NUM;
    }


}

public class WordSearch {
    public static void main(String[] args) {
        System.out.println(new WordSearch_backtracking_solution().exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                },
                "ABCCED"
//                "ABCB"
//                "EE"
        ));
    }
}

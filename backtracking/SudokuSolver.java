//https://leetcode.com/problems/sudoku-solver/description/
package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @time o(9 ^ 81)
 * @space o(81)
 */
public class SudokuSolver {
    public static void main(String[] args) {

    }
}

class Solution {
    public void solveSudoku(char[][] board) {
        List<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        backtrack(board, emptyCells, 0);
    }

    private boolean backtrack(char[][] board, List<int[]> emptyCells, int i) {

        if (i == emptyCells.size()) {
            return true;
        }

        for (int newNum = 1; newNum < 10; newNum++) {

            if (isValid(board, newNum, emptyCells.get(i))) {
                board[emptyCells.get(i)[0]][emptyCells.get(i)[1]] = Character.forDigit(newNum, 10);
                if(backtrack(board, emptyCells, i + 1)){
                    return true;
                }

                board[emptyCells.get(i)[0]][emptyCells.get(i)[1]] = '.';

            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int newNum, int[] cell) {
        for (int i = 0; i < 9; i++) {
            if (board[cell[0]][i] == Character.forDigit(newNum, 10) || board[i][cell[1]] == Character.forDigit(newNum, 10)) {
                return false;
            }


        }
        int rowBox = (cell[0] / 3) * 3;
        int colBox = (cell[1] / 3) * 3;

        for (int i = rowBox; i < rowBox + 3; i++) {
            for (int j = colBox; j < colBox + 3; j++) {
                if (board[i][j] == Character.forDigit(newNum, 10)) {
                    return false;
                }
            }
        }

        return true;
    }
}

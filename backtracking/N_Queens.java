// https://leetcode.com/problems/n-queens/description/
package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @time o(n!)
 * @space o(n^2)
 */
class N_Queens_Backtracking_Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(
                0,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                emptyBoard
        );
        return solutions;
    }

    // Making use of a helper function to get the
    // solutions in the correct output format
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }

        return board;
    }

    private void backtrack(
            int row,
            Set<Integer> diagonals,
            Set<Integer> antiDiagonals,
            Set<Integer> cols,
            char[][] state
    ) {
        // Base case - N queens have been placed
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {
            int negativeDiagonal = row - col;
            int positiveDiagonal = row + col;
            // If the queen is not placeable
            if (
                    cols.contains(col) ||
                            diagonals.contains(negativeDiagonal) ||
                            antiDiagonals.contains(positiveDiagonal)
            ) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(col);
            diagonals.add(negativeDiagonal);
            antiDiagonals.add(positiveDiagonal);
            state[row][col] = 'Q';

            // Move on to the next row with the updated board state
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(negativeDiagonal);
            antiDiagonals.remove(positiveDiagonal);
            state[row][col] = '.';
        }
    }
}

public class N_Queens {

}

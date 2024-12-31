package day4;
public class NQueens {

    public static void main(String[] args) {
        int n = 8; // Change this to solve for a different N
        solveNQueens(n);
    }

    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (placeQueens(board, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists for N = " + n);
        }
    }

    private static boolean placeQueens(int[][] board, int row, int n) {
        // Base case: All queens are placed
        if (row >= n) {
            return true;
        }

        // Try placing a queen in all columns of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                // Place the queen
                board[row][col] = 1;

                // Recur to place the rest of the queens
                if (placeQueens(board, row + 1, n)) {
                    return true;
                }

                // Backtrack: Remove the queen and try next position
                board[row][col] = 0;
            }
        }

        // If the queen cannot be placed in any column, return false
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q" : ".") + " ");
            }
            System.out.println();
        }
    }
}


package day4;
public class GridPaths {

    public static void main(String[] args) {
        int m = 3, n = 3;  // Grid size (3x3 as an example)
        printPaths(m, n);
    }

    public static void printPaths(int m, int n) {
        // Create a 2D array to store the path
        char[][] path = new char[m][n];
        
        // Start the backtracking process from the top-left corner (0, 0)
        findPaths(path, 0, 0, m, n);
    }

    private static void findPaths(char[][] path, int i, int j, int m, int n) {
        // If we've reached the bottom-right corner, print the path
        if (i == m - 1 && j == n - 1) {
            path[i][j] = 'E';  // Mark the end point
            printGrid(path);
            return;
        }

        // Mark the current cell in the path
        path[i][j] = '1';

        // Move Down
        if (i + 1 < m) {
            findPaths(path, i + 1, j, m, n);
        }

        // Move Right
        if (j + 1 < n) {
            findPaths(path, i, j + 1, m, n);
        }

        // Backtrack: Unmark the current cell
        path[i][j] = '0';
    }

    private static void printGrid(char[][] path) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


package day4;
public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        int n = maze.length;
        int[][] solution = new int[n][n];

        if (solveMaze(maze, 0, 0, solution)) {
            printSolution(solution);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean solveMaze(int[][] maze, int x, int y, int[][] solution) {
        int n = maze.length;

        // Base case: Reached the destination
        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is a valid move
        if (isSafe(maze, x, y)) {
            solution[x][y] = 1; // Mark the current cell as part of the solution path

            // Move down
            if (solveMaze(maze, x + 1, y, solution)) {
                return true;
            }

            // Move right
            if (solveMaze(maze, x, y + 1, solution)) {
                return true;
            }

            // Backtrack: Unmark this cell
            solution[x][y] = 0;
        }

        return false;
    }

    public static boolean isSafe(int[][] maze, int x, int y) {
        int n = maze.length;
        return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1;
    }

    public static void printSolution(int[][] solution) {
        for (int[] row : solution) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


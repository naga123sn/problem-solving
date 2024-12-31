package day4;
public class StaircaseWays {
    public static void main(String[] args) {
        int n = 5; // Number of steps
        System.out.println("Number of ways to climb " + n + " steps: " + countWays(n));
    }

    public static int countWays(int n) {
        if (n == 0) {
            return 1; // 1 way to stay at the ground
        }
        if (n < 0) {
            return 0; // No way to climb negative steps
        }
        // Recursive case: sum of ways to climb n-1 and n-2 steps
        return countWays(n - 1) + countWays(n - 2);
    }
}


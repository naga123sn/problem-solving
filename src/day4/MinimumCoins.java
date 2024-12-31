package day4;
import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // Array of coin denominations
        int amount = 11; // Target amount

        int result = findMinimumCoins(coins, amount);
        if (result == -1) {
            System.out.println("It is not possible to make change for the amount " + amount);
        } else {
            System.out.println("The minimum number of coins required: " + result);
        }
    }

    public static int findMinimumCoins(int[] coins, int amount) {
        // Array to store the minimum coins required for each amount up to 'amount'
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill with a large value
        dp[0] = 0; // Base case: 0 coins to make amount 0

        // Iterate through all amounts from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] is still a large value, it's not possible to make change
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


package day3;
public class LongestCommonSubstring {

    // Method to find the longest common substring
    public static String longestCommonSubstring(String str1, String str2) {
        int maxLength = 0; // Length of the longest common substring
        int endIndex = 0;  // End index of the longest common substring in str1

        // Create a 2D array to store lengths of common suffixes
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // Build the dp array
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                // If characters match, increment the length of the common substring
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // Update maxLength and endIndex if a longer common substring is found
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // If no common substring is found, return an empty string
        if (maxLength == 0) {
            return "";
        }

        // Extract the longest common substring using the endIndex and maxLength
        return str1.substring(endIndex - maxLength + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "zcdemfgh";

        String result = longestCommonSubstring(str1, str2);

        if (result.isEmpty()) {
            System.out.println("No common substring found.");
        } else {
            System.out.println("The longest common substring is: " + result);
        }
    }
}


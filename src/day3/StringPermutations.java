package day3;
import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println("All permutations of the string are:");
        // Find and print all permutations
        findPermutations(input, "");

        // Close the scanner
        scanner.close();
    }

    private static void findPermutations(String str, String prefix) {
        // Base case: if the string is empty, print the prefix
        if (str.isEmpty()) {
            System.out.println(prefix);
            return;
        }

        // Recursive case: iterate over the string
        for (int i = 0; i < str.length(); i++) {
            // Take the current character
            char currentChar = str.charAt(i);

            // Remaining string after removing the current character
            String remaining = str.substring(0, i) + str.substring(i + 1);

            // Recursive call with the updated prefix and remaining string
            findPermutations(remaining, prefix + currentChar);
        }
    }
}


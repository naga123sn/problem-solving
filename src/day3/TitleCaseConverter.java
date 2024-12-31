package day3;
import java.util.Scanner;

public class TitleCaseConverter {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // Convert the string to title case
        String titleCaseString = toTitleCase(input);

        // Display the result
        System.out.println("String in title case:");
        System.out.println(titleCaseString);

        // Close the scanner
        scanner.close();
    }

    private static String toTitleCase(String str) {
        // Split the string into words
        String[] words = str.split(" ");
        StringBuilder titleCase = new StringBuilder();

        // Convert each word to title case
        for (String word : words) {
            if (!word.isEmpty()) {
                // Convert the first character to uppercase and the rest to lowercase
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase())
                         .append(" ");
            }
        }

        // Trim the trailing space and return the result
        return titleCase.toString().trim();
    }
}

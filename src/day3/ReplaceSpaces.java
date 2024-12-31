package day3;
import java.util.Scanner;

public class ReplaceSpaces {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a string
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // Replace all spaces with '%20'
        String result = input.replace(" ", "%20");

        // Display the result
        System.out.println("String after replacing spaces with '%20':");
        System.out.println(result);

        // Close the scanner
        scanner.close();
    }
}

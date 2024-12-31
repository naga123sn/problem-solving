package day3;
import java.util.Scanner;

public class StringRotationCheck {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the first string
        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();

        // Prompt the user for the second string
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        // Check if the strings are rotations of each other
        boolean isRotation = checkRotation(str1, str2);

        // Display the result
        if (isRotation) {
            System.out.println("The second string is a rotation of the first string.");
        } else {
            System.out.println("The second string is not a rotation of the first string.");
        }

        // Close the scanner
        scanner.close();
    }

    private static boolean checkRotation(String str1, String str2) {
        // Check if the lengths of the strings are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Concatenate str1 with itself and check if str2 is a substring
        String concatenated = str1 + str1;
        return concatenated.contains(str2);
    }
}


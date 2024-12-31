package day3;
import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a sentence
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        // Reverse the words in the sentence
        String reversedSentence = reverseWords(sentence);

        // Display the reversed sentence
        System.out.println("Reversed sentence:");
        System.out.println(reversedSentence);

        // Close the scanner
        scanner.close();
    }

    private static String reverseWords(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Use a StringBuilder to build the reversed sentence
        StringBuilder reversed = new StringBuilder();

        // Iterate through the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);

            // Add a space if it's not the last word
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}


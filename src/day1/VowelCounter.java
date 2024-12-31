package day1;
import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Count vowels
        int vowelCount = countVowels(input);

        // Display result
        System.out.println("The number of vowels in the string is: " + vowelCount);

        scanner.close();
    }

    // Method to count vowels in a string
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU"; // Both lowercase and uppercase vowels

        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) { // Check if the character is a vowel
                count++;
            }
        }
        return count;
    }
}

output :
Enter a string: Varshith
The number of vowels in the string is: 2


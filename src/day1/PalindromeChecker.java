package day1;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        // Convert the string to lowercase and remove spaces for case-insensitive comparison
        String processedString = input.replaceAll("\\s+", "").toLowerCase();

        if (isPalindrome(processedString)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}

OUTPUT :
Enter a string to check if it's a palindrome: MADAM
"MADAM" is a palindrome.

Enter a string to check if it's a palindrome: Hello
"Hello" is not a palindrome.

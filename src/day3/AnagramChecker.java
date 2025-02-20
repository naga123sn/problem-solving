package day3;
import java.util.Arrays;

public class AnagramChecker {

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // If the lengths are not equal, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert both strings to character arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}


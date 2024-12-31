package day2;
import java.util.Scanner;

public class RemoveDuplicates {

    // Function to remove duplicates from a sorted array
    public static int removeDuplicates(int[] array) {
        if (array.length == 0) {
            return 0; // No elements in the array
        }

        int uniqueIndex = 1; // Index to track unique elements (start from second element)

        for (int i = 1; i < array.length; i++) {
            // If the current element is not the same as the previous one, add it to the unique index
            if (array[i] != array[i - 1]) {
                array[uniqueIndex] = array[i];
                uniqueIndex++;
            }
        }

        return uniqueIndex; // Returns the new length of the array with unique elements
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sorted array
        System.out.println("Enter the size of the sorted array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Remove duplicates
        int newLength = removeDuplicates(array);

        // Output the result
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(array[i] + " ");
        }

        scanner.close();
    }
}


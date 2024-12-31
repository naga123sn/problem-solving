package day2;
import java.util.Scanner;

public class BinarySearch {
    // Function to perform binary search
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is at the mid
            if (array[mid] == target) {
                return mid; // Target found, return index
            }

            // If the target is greater, ignore the left half
            if (array[mid] < target) {
                left = mid + 1;
            }
            // If the target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
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

        // Input target element
        System.out.println("Enter the target element to search:");
        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(array, target);

        // Output the result
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }

        scanner.close();
    }
}

OUTPUT :

Enter the size of the sorted array:
8
Enter 8 elements of the sorted array:
1 2 3 4 5 6 7 8
Enter the target element to search:
6
Element found at index: 5



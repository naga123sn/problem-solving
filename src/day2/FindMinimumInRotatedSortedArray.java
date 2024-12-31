package day2;
import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {

    // Function to find the minimum element in a rotated sorted array
    public static int findMinimum(int[] array) {
        int left = 0;
        int right = array.length - 1;

        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element, the minimum is on the right side
            if (array[mid] > array[right]) {
                left = mid + 1;
            }
            // Otherwise, the minimum is on the left side (including mid)
            else {
                right = mid;
            }
        }

        // At the end of the binary search, left will point to the minimum element
        return array[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array size and elements
        System.out.println("Enter the size of the rotated sorted array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Find the minimum element
        int minimum = findMinimum(array);

        // Output the minimum element
        System.out.println("The minimum element is: " + minimum);

        scanner.close();
    }
}

OUTPUT :
Enter the size of the rotated sorted array:
7
Enter 7 elements of the rotated sorted array:
1 2 3 4 5 6 7
The minimum element is: 1


package day2;
import java.util.Scanner;

public class SecondLargestElement {

    // Function to find the second largest element in the array
    public static int findSecondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse the array to find the largest and second largest elements
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                secondLargest = largest; // Update second largest
                largest = array[i]; // Update largest
            } else if (array[i] > secondLargest && array[i] != largest) {
                secondLargest = array[i]; // Update second largest
            }
        }

        // Return the second largest element if found, else return -1
        return secondLargest != Integer.MIN_VALUE ? secondLargest : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array size and elements
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Find the second largest element
        int secondLargest = findSecondLargest(array);

        // Output the result
        if (secondLargest != -1) {
            System.out.println("The second largest element is: " + secondLargest);
        } else {
            System.out.println("There is no second largest element.");
        }

        scanner.close();
    }
}

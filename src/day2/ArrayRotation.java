package day2;
import java.util.Scanner;

public class ArrayRotation {

    // Function to rotate the array to the right by 'd' positions
    public static void rotateArray(int[] array, int d) {
        int n = array.length;

        // If d is greater than the array length, take modulus to avoid extra rotations
        d = d % n;

        // Reverse the entire array
        reverse(array, 0, n - 1);

        // Reverse the first part of the array (0 to d-1)
        reverse(array, 0, d - 1);

        // Reverse the second part of the array (d to n-1)
        reverse(array, d, n - 1);
    }

    // Helper function to reverse a portion of the array
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Function to print the array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
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

        // Input the number of positions to rotate
        System.out.println("Enter the number of positions to rotate:");
        int d = scanner.nextInt();

        // Rotate the array
        rotateArray(array, d);

        // Output the rotated array
        System.out.println("Array after rotation:");
        printArray(array);

        scanner.close();
    }
}

OUTPUT :
Enter the size of the array:
6
Enter 6 elements of the array:
1 2 3 4 5 6
Enter the number of positions to rotate:
3
Array after rotation:
4 5 6 1 2 3 



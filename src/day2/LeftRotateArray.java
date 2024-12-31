package day2;
import java.util.Scanner;

public class LeftRotateArray {

    // Function to left rotate the array by one position
    public static void leftRotateByOne(int[] array) {
        int firstElement = array[0];

        // Shift all elements to the left by one position
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        // Move the first element to the last position
        array[array.length - 1] = firstElement;
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

        // Left rotate the array by one position
        leftRotateByOne(array);

        // Output the rotated array
        System.out.println("Array after left rotation by one position:");
        printArray(array);

        scanner.close();
    }
}

OUTPUT :
Enter the size of the array:
8
Enter 8 elements of the array:
1 2 3 4 5 6 7 8
Array after left rotation by one position:
2 3 4 5 6 7 8 1 



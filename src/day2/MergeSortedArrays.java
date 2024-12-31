package day2;
import java.util.Scanner;

public class MergeSortedArrays {

    // Function to merge two sorted arrays
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int n1 = array1.length;
        int n2 = array2.length;
        int[] mergedArray = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < n1 && j < n2) {
            if (array1[i] < array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        // Copy remaining elements of array1
        while (i < n1) {
            mergedArray[k++] = array1[i++];
        }

        // Copy remaining elements of array2
        while (j < n2) {
            mergedArray[k++] = array2[j++];
        }

        return mergedArray;
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

        // Input the first sorted array
        System.out.println("Enter the size of the first sorted array:");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];

        System.out.println("Enter " + n1 + " elements of the first sorted array:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Input the second sorted array
        System.out.println("Enter the size of the second sorted array:");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];

        System.out.println("Enter " + n2 + " elements of the second sorted array:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Merge the two sorted arrays
        int[] mergedArray = mergeArrays(array1, array2);

        // Output the merged sorted array
        System.out.println("Merged sorted array:");
        printArray(mergedArray);

        scanner.close();
    }
}

OUTPUT :
Enter the size of the first sorted array:
6
Enter 6 elements of the first sorted array:
1 2 3 4 5 6
Enter the size of the second sorted array:
6
Enter 6 elements of the second sorted array:
1 2 3 4 5 6
Merged sorted array:
1 1 2 2 3 3 4 4 5 5 6 6 


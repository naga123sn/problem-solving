package day2;
import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutation {

    // Function to check if two arrays are permutations of each other
    public static boolean arePermutations(int[] array1, int[] array2) {
        // If the arrays have different lengths, they cannot be permutations
        if (array1.length != array2.length) {
            return false;
        }

        // Sort both arrays
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Compare the sorted arrays element by element
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        // If all elements match, the arrays are permutations of each other
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the first array
        System.out.println("Enter the size of the first array:");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];

        System.out.println("Enter " + n1 + " elements of the first array:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Input the second array
        System.out.println("Enter the size of the second array:");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];

        System.out.println("Enter " + n2 + " elements of the second array:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Check if the arrays are permutations of each other
        if (arePermutations(array1, array2)) {
            System.out.println("The arrays are permutations of each other.");
        } else {
            System.out.println("The arrays are not permutations of each other.");
        }

        scanner.close();
    }
}

OUTPUT :
Enter the size of the first array:
5
Enter 5 elements of the first array:
1 2 3 4 5
Enter the size of the second array:
5
Enter 5 elements of the second array:
1 2 3 4 5
The arrays are permutations of each other.


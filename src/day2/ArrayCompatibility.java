package day2;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayCompatibility {

    // Function to check if two arrays are compatible (i.e., have the same elements in any order)
    public static boolean areCompatible(int[] array1, int[] array2) {
        // If the lengths of the arrays are not equal, they are not compatible
        if (array1.length != array2.length) {
            return false;
        }

        // Sort both arrays
        Arrays.sort(array1);
        Arrays.sort(array2);

        // Check if the sorted arrays are equal
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first array
        System.out.println("Enter the size of the first array:");
        int n1 = scanner.nextInt();
        int[] array1 = new int[n1];

        System.out.println("Enter " + n1 + " elements of the first array:");
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Input for the second array
        System.out.println("Enter the size of the second array:");
        int n2 = scanner.nextInt();
        int[] array2 = new int[n2];

        System.out.println("Enter " + n2 + " elements of the second array:");
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Check if the arrays are compatible
        if (areCompatible(array1, array2)) {
            System.out.println("The arrays are compatible.");
        } else {
            System.out.println("The arrays are not compatible.");
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
The arrays are compatible.

Enter the size of the first array:
5
Enter 5 elements of the first array:
1 2 3 4 5
Enter the size of the second array:
6
Enter 6 elements of the second array:
1 2 3 4 5 6
The arrays are not compatible.



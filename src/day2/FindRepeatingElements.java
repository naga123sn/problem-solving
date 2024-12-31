package day2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindRepeatingElements {

    // Function to find repeating elements in the array
    public static void findRepeatingElements(int[] array) {
        Set<Integer> seen = new HashSet<>();
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            // If the element is already in the set, it's a repeating element
            if (seen.contains(array[i])) {
                System.out.println("Repeating element: " + array[i]);
                found = true;
            } else {
                // Add the element to the set
                seen.add(array[i]);
            }
        }

        if (!found) {
            System.out.println("No repeating elements found.");
        }
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

        // Find repeating elements
        findRepeatingElements(array);

        scanner.close();
    }
}

OUTPUT :
Enter the size of the array:
6
Enter 6 elements of the array:
1 1 2 3 4 4
Repeating element: 1
Repeating element: 4



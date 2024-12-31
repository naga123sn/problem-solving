package day6;
import java.util.ArrayList;
import java.util.List;

public class IntersectionOfArrays {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 4, 6, 8}; // Example sorted array 1
        int[] array2 = {2, 4, 6, 9};    // Example sorted array 2

        List<Integer> intersection = findIntersection(array1, array2);

        System.out.println("Intersection of the two arrays: " + intersection);
    }

    public static List<Integer> findIntersection(int[] array1, int[] array2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays using two pointers
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                // If both elements are equal, add to the result
                result.add(array1[i]);
                i++;
                j++;
            } else if (array1[i] < array2[j]) {
                // If array1[i] is smaller, move pointer i
                i++;
            } else {
                // If array2[j] is smaller, move pointer j
                j++;
            }
        }

        return result;
    }
}


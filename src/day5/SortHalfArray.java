package day5;
import java.util.Arrays;

public class SortHalfArray {

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 7, 1, 4, 6};  // Example input
        System.out.println("Original array: " + Arrays.toString(arr));
        
        sortHalf(arr);
        
        System.out.println("Array after sorting the first half: " + Arrays.toString(arr));
    }

    public static void sortHalf(int[] arr) {
        // Find the middle index
        int middle = arr.length / 2;

        // Sort the first half of the array (index 0 to middle-1)
        Arrays.sort(arr, 0, middle);
    }
}


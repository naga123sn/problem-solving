package day6;
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Example sorted array
        int target = 7; // Target value to search for

        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2; // To avoid overflow

            if (array[mid] == target) {
                return mid; // Element found at index mid
            } else if (array[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        // If the element is not found
        return -1;
    }
}


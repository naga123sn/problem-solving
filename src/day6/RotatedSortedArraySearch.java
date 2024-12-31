package day6;
public class RotatedSortedArraySearch {
    
    public static void main(String[] args) {
        int[] array = {15, 18, 2, 3, 6, 12}; // Example rotated sorted array
        int target = 3; // Target value to search for

        int result = search(array, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (array[mid] == target) {
                return mid;
            }

            // Determine which part of the array is sorted
            if (array[left] <= array[mid]) { // Left part is sorted
                if (target >= array[left] && target < array[mid]) {
                    right = mid - 1; // Target is in the left part
                } else {
                    left = mid + 1; // Target is in the right part
                }
            } else { // Right part is sorted
                if (target > array[mid] && target <= array[right]) {
                    left = mid + 1; // Target is in the right part
                } else {
                    right = mid - 1; // Target is in the left part
                }
            }
        }

        // If the element is not found, return -1
        return -1;
    }
}


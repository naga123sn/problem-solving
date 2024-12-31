package day6;
public class TernarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19}; // Example sorted array
        int target = 7; // Target value to search for

        int result = ternarySearch(array, 0, array.length - 1, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int ternarySearch(int[] array, int left, int right, int target) {
        // If the right index is greater than or equal to left index
        while (left <= right) {
            // Calculate two mid points
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            // Check if the target is at any of the mid points
            if (array[mid1] == target) {
                return mid1;
            } else if (array[mid2] == target) {
                return mid2;
            }

            // If the target is less than mid1, search in the left third
            if (target < array[mid1]) {
                right = mid1 - 1;
            }
            // If the target is greater than mid2, search in the right third
            else if (target > array[mid2]) {
                left = mid2 + 1;
            }
            // If the target is between mid1 and mid2, search in the middle third
            else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }

        // Target not found
        return -1;
    }
}


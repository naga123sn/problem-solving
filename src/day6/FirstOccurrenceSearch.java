package day6;
public class FirstOccurrenceSearch {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 4, 4, 5, 6}; // Example sorted array
        int target = 4; // Target value to search for

        int result = findFirstOccurrence(array, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("First occurrence of element " + target + " is at index: " + result);
        }
    }

    public static int findFirstOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If target is found, store the index and continue searching to the left
            if (array[mid] == target) {
                result = mid;
                right = mid - 1; // Move towards the left to find the first occurrence
            }
            // If target is smaller, search in the left half
            else if (array[mid] > target) {
                right = mid - 1;
            }
            // If target is larger, search in the right half
            else {
                left = mid + 1;
            }
        }

        return result; // Return the first occurrence or -1 if not found
    }
}


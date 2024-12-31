package day6;
public class CountOccurrences {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 4, 4, 5, 6}; // Example sorted array
        int target = 4; // Target element to count occurrences

        int count = countOccurrences(array, target);

        System.out.println("The element " + target + " appears " + count + " times in the array.");
    }

    public static int countOccurrences(int[] array, int target) {
        int firstIndex = findFirstOccurrence(array, target);
        int lastIndex = findLastOccurrence(array, target);

        if (firstIndex == -1 || lastIndex == -1) {
            return 0; // Element not found
        }

        // Count of occurrences is the difference between the last and first index + 1
        return lastIndex - firstIndex + 1;
    }

    // Function to find the first occurrence of the target
    public static int findFirstOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching in the left part
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // Function to find the last occurrence of the target
    public static int findLastOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching in the right part
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}

package day6;
public class RangeOfElementInSortedArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4, 5}; // Example sorted array
        int target = 2; // Target element to search for

        int[] range = findRange(array, target);

        if (range[0] == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("The range of indices for element " + target + " is: [" + range[0] + ", " + range[1] + "]");
        }
    }

    public static int[] findRange(int[] array, int target) {
        int[] result = {-1, -1}; // Default result if the target is not found

        result[0] = findFirstOccurrence(array, target);
        if (result[0] == -1) {
            return result; // If the element is not found, return [-1, -1]
        }

        result[1] = findLastOccurrence(array, target);
        return result;
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
                right = mid - 1; // Move left to find the first occurrence
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
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
                left = mid + 1; // Move right to find the last occurrence
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}


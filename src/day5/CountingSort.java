package day5;
public class CountingSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1}; // Example array

        countingSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void countingSort(int[] array) {
        if (array.length == 0) {
            return; // Empty array, no sorting needed
        }

        // Find the maximum value in the array to determine the range
        int max = findMax(array);

        // Create a count array to store the frequency of each number
        int[] count = new int[max + 1];

        // Count the occurrences of each element in the array
        for (int num : array) {
            count[num]++;
        }

        // Modify the count array by cumulative sum
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Output the sorted array
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted array back into the original array
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    // Helper function to find the maximum element in the array
    private static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}


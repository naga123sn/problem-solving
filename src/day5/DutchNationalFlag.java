package day5;
public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 1, 0}; // Example input

        dutchNationalFlagSort(array);

        // Print the sorted array
        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void dutchNationalFlagSort(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        // Traverse the array with the mid pointer
        while (mid <= high) {
            if (array[mid] == 0) {
                // Swap array[low] and array[mid], move low and mid forward
                swap(array, low, mid);
                low++;
                mid++;
            } else if (array[mid] == 1) {
                // Move mid pointer forward for 1
                mid++;
            } else {
                // Swap array[mid] and array[high], move high backward
                swap(array, mid, high);
                high--;
            }
        }
    }

    // Helper function to swap two elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


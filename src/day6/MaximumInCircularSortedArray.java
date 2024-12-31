package day6;
public class MaximumInCircularSortedArray {

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2}; // Example circular sorted array

        int maxElement = findMax(array);

        System.out.println("The maximum element in the circular sorted array is: " + maxElement);
    }

    public static int findMax(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the maximum element
            if (mid < right && array[mid] > array[mid + 1]) {
                return array[mid];
            } else if (mid > left && array[mid] < array[mid - 1]) {
                return array[mid - 1];
            }

            // Decide which half to search
            if (array[mid] >= array[left]) {
                left = mid + 1; // Maximum is in the right half
            } else {
                right = mid - 1; // Maximum is in the left half
            }
        }

        return array[left]; // Return the only element if array is not rotated
    }
}

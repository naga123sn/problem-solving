package day5;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4}; // Example array
        int k = 2; // Find the 2nd largest element

        int result = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public static int findKthLargest(int[] nums, int k) {
        // Create a min-heap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the heap
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}


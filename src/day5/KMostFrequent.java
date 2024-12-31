package day5;
import java.util.*;

public class KMostFrequent {

    public static void main(String[] args) {
        int[] num = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println("The " + k + " most frequent elements are: " + findKMostFrequent(num, k));
    }

    public static List<Integer> findKMostFrequent(int[] num, int k) {
        // Step 1: Count the frequency of each element in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : num) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // Step 2: Use a priority queue (min-heap) to store the k most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue());  // Compare by frequency

        // Step 3: Add each entry in the frequency map to the heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the element with the least frequency
            }
        }

        // Step 4: Extract the k most frequent elements from the heap
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Step 5: Reverse the list to get the most frequent elements first
        Collections.reverse(result);
        return result;
    }
}

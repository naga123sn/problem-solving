package day7;
import java.util.Arrays;

class PriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    // Constructor to initialize the priority queue
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the priority queue
    public int size() {
        return size;
    }

    // Method to get the minimum element (root of the heap)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return heap[0];
    }

    // Method to insert an element into the priority queue
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Priority Queue is full");
        }
        heap[size] = value;
        size++;
        // Fix the min-heap property after insertion
        heapifyUp(size - 1);
    }

    // Method to remove and return the minimum element (root of the heap)
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        // The root is the minimum element, so we remove it
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        // Fix the min-heap property after removal
        heapifyDown(0);
        return min;
    }

    // Helper method to maintain the min-heap property after insertion
    private void heapifyUp(int index) {
        while (index > 0 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Helper method to maintain the min-heap property after removal
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        if (leftChild < size && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < size && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Helper method to get the index of the parent
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Helper method to get the index of the left child
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Helper method to get the index of the right child
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Method to display the elements of the priority queue
    public void display() {
        System.out.println("Priority Queue elements: " + Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }
}

public class Main6 {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);

        pq.insert(10);
        pq.insert(20);
        pq.insert(5);
        pq.insert(30);
        pq.insert(15);

        pq.display(); // Display elements in the priority queue

        System.out.println("The minimum element is: " + pq.peek());

        System.out.println("Removed element: " + pq.remove());
        pq.display(); // Display elements after removal

        System.out.println("Removed element: " + pq.remove());
        pq.display(); // Display elements after another removal
    }
}


package day7;
class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue with a fixed size
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {  // If the queue is empty, set both front and rear to 0
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;  // Circular increment of rear
        }

        queue[rear] = value;
        size++;
        System.out.println(value + " added to the queue");
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = queue[front];
        if (front == rear) {  // If the queue has only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;  // Circular increment of front
        }

        size--;
        return value;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return queue[front];
        }
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Queue elements: ");
        for (int i = front; i != rear; i = (i + 1) % capacity) {
            System.out.print(queue[i] + " ");
        }
        System.out.println(queue[rear]);  // Print the last element
    }
}

public class Main5 {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();  // Display queue elements

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();  // Display queue elements after dequeueing

        queue.enqueue(60);
        queue.enqueue(70);

        queue.display();  // Display queue elements after enqueueing new elements
    }
}


package day7;
class QueueArray {
    private int[] queue;
    private int front, rear, capacity;
    
    public QueueArray(int size) {
        capacity = size;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }
    
    // Check if the queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }
    
    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
    
    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {  // First element in the queue
                front = 0;
            }
            queue[++rear] = value;
            System.out.println(value + " added to the queue");
        }
    }
    
    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            int value = queue[front++];
            if (front > rear) {
                front = rear = -1; // Reset the queue when it becomes empty
            }
            return value;
        }
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
}

public class Main3 {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element is " + queue.peek());
        System.out.println(queue.dequeue() + " removed from the queue");
        System.out.println("Front element is " + queue.peek());
    }
}


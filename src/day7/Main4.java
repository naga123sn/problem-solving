package day7;
class QueueLinkedList {
    private Node front, rear;
    
    // Node class to represent each element in the queue
    private static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Constructor
    public QueueLinkedList() {
        front = rear = null;
    }
    
    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode; // If the queue is empty, both front and rear are the new node
        } else {
            rear.next = newNode; // Add the new node at the rear
            rear = newNode;
        }
        System.out.println(value + " added to the queue");
    }
    
    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            int value = front.data;
            front = front.next;
            if (front == null) { // If the queue becomes empty after dequeue
                rear = null;
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
            return front.data;
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element is " + queue.peek());
        System.out.println(queue.dequeue() + " removed from the queue");
        System.out.println("Front element is " + queue.peek());
    }
}


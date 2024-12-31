package day8;
public class StackUsingLinkedList {
    // Node class representing each element in the stack
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack implementation using a linked list
    static class Stack {
        private Node top;

        public Stack() {
            top = null; // Initialize the stack as empty
        }

        // Push an element onto the stack
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top; // Point new node to the current top
            top = newNode;      // Update the top
            System.out.println(data + " pushed onto stack.");
        }

        // Pop an element from the stack
        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack Underflow! Cannot pop from an empty stack.");
            }
            int popped = top.data;
            top = top.next; // Move the top to the next node
            return popped;
        }

        // Peek the top element of the stack
        public int peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty! Cannot peek.");
            }
            return top.data;
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return top == null;
        }

        // Display the stack
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            System.out.print("Stack elements: ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        stack.display();

        // Peek the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop elements from the stack
        System.out.println(stack.pop() + " popped from stack.");
        stack.display();

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}


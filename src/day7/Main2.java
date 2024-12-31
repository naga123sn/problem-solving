package day7;
class StackLinkedList {
    private Node top;

    // Node class to represent a stack element
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println(value + " pushed to stack");
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    // Peek operation
    public int peek() {
        if (top == null) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return top.data;
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

public class Main2 {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element is " + stack.peek());
        System.out.println(stack.pop() + " popped from stack");
        System.out.println("Top element is " + stack.peek());
    }
}

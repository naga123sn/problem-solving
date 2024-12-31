package day8;
public class RotateLinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Rotate the linked list by k nodes
    public static Node rotate(Node head, int k) {
        if (head == null || k == 0) {
            return head; // No rotation needed for an empty list or k = 0
        }

        // Find the length of the list and the tail node
        Node current = head;
        int length = 1; // At least one node is present
        while (current.next != null) {
            current = current.next;
            length++;
        }

        Node tail = current; // Current is now the tail
        k = k % length; // Handle cases where k >= length
        if (k == 0) {
            return head; // No rotation needed if k is a multiple of length
        }

        // Find the new head after k rotations
        int stepsToNewHead = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Update pointers to rotate the list
        Node newHead = newTail.next;
        newTail.next = null; // Break the list
        tail.next = head;    // Connect the tail to the original head

        return newHead;
    }

    // Display the linked list
    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Create a sample linked list and rotate it
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        display(head);

        int k = 2; // Number of rotations
        head = rotate(head, k);

        System.out.println("List After Rotating by " + k + " Nodes:");
        display(head);
    }
}


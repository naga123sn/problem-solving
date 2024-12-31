package day8;
import java.util.HashSet;

public class RemoveDuplicatesFromLinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Remove duplicates from the linked list
    public static void removeDuplicates(Node head) {
        if (head == null) {
            return; // No duplicates to remove if the list is empty
        }

        HashSet<Integer> seen = new HashSet<>(); // Store seen values
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                // Duplicate found: remove the current node
                previous.next = current.next;
            } else {
                // Add the value to the set and move previous forward
                seen.add(current.data);
                previous = current;
            }
            current = current.next;
        }
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

    // Create a sample linked list and remove duplicates
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 2 -> 4 -> 3 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        display(head);

        // Remove duplicates
        removeDuplicates(head);

        System.out.println("List After Removing Duplicates:");
        display(head);
    }
}


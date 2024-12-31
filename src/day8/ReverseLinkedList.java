package day8;
public class ReverseLinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse the linked list
    public static Node reverse(Node head) {
        Node previous = null; // Previous node starts as null
        Node current = head;  // Start with the head node

        while (current != null) {
            Node nextNode = current.next; // Store the next node
            current.next = previous;     // Reverse the current node's pointer
            previous = current;          // Move previous one step forward
            current = nextNode;          // Move current one step forward
        }

        return previous; // New head of the reversed list
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

    // Create a sample linked list and reverse it
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        display(head);

        // Reverse the list
        head = reverse(head);

        System.out.println("Reversed List:");
        display(head);
    }
}


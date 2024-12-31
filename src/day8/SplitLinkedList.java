package day8;
public class SplitLinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Split the linked list into two halves
    public static Node[] splitList(Node head) {
        if (head == null || head.next == null) {
            return new Node[]{head, null}; // No split needed for empty or single-node list
        }

        // Use two pointers to find the middle
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;       // Keep track of the node before slow
            slow = slow.next;  // Move slow one step
            fast = fast.next.next; // Move fast two steps
        }

        // Split the list
        prev.next = null; // Break the list into two parts
        Node firstHalf = head;
        Node secondHalf = slow;

        return new Node[]{firstHalf, secondHalf};
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

    // Create a sample linked list and split it
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        display(head);

        // Split the list
        Node[] halves = splitList(head);

        System.out.println("First Half:");
        display(halves[0]);

        System.out.println("Second Half:");
        display(halves[1]);
    }
}

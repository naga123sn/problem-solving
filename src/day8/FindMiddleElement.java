package day8;
public class FindMiddleElement {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find the middle element of the linked list
    public static Node findMiddle(Node head) {
        if (head == null) {
            return null; // Return null if the list is empty
        }

        Node slow = head; // Slow pointer moves one step
        Node fast = head; // Fast pointer moves two steps

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow one step
            fast = fast.next.next;     // Move fast two steps
        }

        return slow; // Slow pointer will be at the middle
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

    // Create a sample linked list and find the middle element
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Linked List:");
        display(head);

        // Find the middle element
        Node middle = findMiddle(head);
        if (middle != null) {
            System.out.println("Middle Element: " + middle.data);
        } else {
            System.out.println("The list is empty, no middle element.");
        }
    }
}

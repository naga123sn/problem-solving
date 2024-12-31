package day8;
public class DetectCycleInLinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Detect if there's a cycle in the linked list
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node
        }

        Node slow = head; // Slow pointer moves one step at a time
        Node fast = head; // Fast pointer moves two steps at a time

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow one step
            fast = fast.next.next;     // Move fast two steps

            if (slow == fast) {        // Cycle detected
                return true;
            }
        }

        return false; // No cycle
    }

    // Create a sample linked list with a cycle for testing
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }

        // To test a non-cyclic list, comment out the line creating the cycle:
        // head.next.next.next.next.next = null;
    }
}


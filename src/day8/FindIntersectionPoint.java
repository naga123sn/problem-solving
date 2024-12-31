package day8;
public class FindIntersectionPoint {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find the intersection point of two linked lists
    public static Node findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        // Get the lengths of both lists
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        // Align the heads of both lists
        while (length1 > length2) {
            head1 = head1.next;
            length1--;
        }
        while (length2 > length1) {
            head2 = head2.next;
            length2--;
        }

        // Traverse both lists to find the intersection point
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1; // Intersection point
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null; // No intersection
    }

    // Get the length of a linked list
    public static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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

    // Create two sample linked lists with an intersection point
    public static void main(String[] args) {
        // Create first linked list: 1 -> 2 -> 3
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        // Create second linked list: 4 -> 5
        Node head2 = new Node(4);
        head2.next = new Node(5);

        // Create intersection: 6 -> 7
        Node intersection = new Node(6);
        intersection.next = new Node(7);

        head1.next.next.next = intersection; // Connect 3 -> 6
        head2.next.next = intersection;      // Connect 5 -> 6

        System.out.println("List 1:");
        display(head1);

        System.out.println("List 2:");
        display(head2);

        // Find the intersection point
        Node intersectionPoint = findIntersection(head1, head2);
        if (intersectionPoint != null) {
            System.out.println("Intersection Point: " + intersectionPoint.data);
        } else {
            System.out.println("No Intersection Point.");
        }
    }
}


package day8;
public class SinglyLinkedList {
    // Node class representing each element in the list
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the list

    // Add a node to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // Set head if list is empty
        } else {
            Node current = head;
            while (current.next != null) { // Traverse to the end
                current = current.next;
            }
            current.next = newNode; // Append the new node
        }
    }

    // Remove a node by value
    public void remove(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data == data) { // If the head node needs to be removed
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found in the list.");
        } else {
            current.next = current.next.next; // Remove the node
        }
    }

    // Display the list
    public void display() {
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

    // Search for a value in the list
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Initial List:");
        list.display();

        // Removing an element
        list.remove(20);
        System.out.println("After Removing 20:");
        list.display();

        // Searching for an element
        System.out.println("Search for 30: " + list.search(30));
        System.out.println("Search for 40: " + list.search(40));

        // Display the final list
        System.out.println("Final List:");
        list.display();
    }
}


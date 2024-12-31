package day9;
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

// Node for the linked list
class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        next = null;
    }
}

public class BSTToLinkedList {
    // Head and tail pointers for the linked list
    private static ListNode head = null;
    private static ListNode tail = null;

    // Function to convert BST to sorted linked list
    public static void convertToLinkedList(TreeNode root) {
        if (root == null) {
            return;
        }

        // Recursive call for left subtree
        convertToLinkedList(root.left);

        // Process the current node
        ListNode newNode = new ListNode(root.value);
        if (head == null) {
            // Initialize the linked list with the first node
            head = newNode;
            tail = newNode;
        } else {
            // Append the new node to the linked list
            tail.next = newNode;
            tail = newNode;
        }

        // Recursive call for right subtree
        convertToLinkedList(root.right);
    }

    // Function to print the linked list
    public static void printLinkedList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Convert the BST to a sorted linked list
        convertToLinkedList(root);

        // Print the resulting linked list
        System.out.println("Sorted Linked List:");
        printLinkedList();
    }
}

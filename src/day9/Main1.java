package day9;
// Class representing a node in the BST
class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

// Class representing the BST
class BinarySearchTree {
    TreeNode root;

    // Method to insert a node into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Method to search for a value in the BST
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(TreeNode root, int value) {
        if (root == null) {
            return false; // Value not found
        }
        if (root.value == value) {
            return true; // Value found
        }
        return value < root.value
                ? searchRec(root.left, value)
                : searchRec(root.right, value);
    }
}

// Main class to test the BST
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Search for elements in the BST
        int key = 40;
        if (bst.search(key)) {
            System.out.println(key + " is found in the BST.");
        } else {
            System.out.println(key + " is not found in the BST.");
        }

        key = 90;
        if (bst.search(key)) {
            System.out.println(key + " is found in the BST.");
        } else {
            System.out.println(key + " is not found in the BST.");
        }
    }
}

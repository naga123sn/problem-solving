package day9;
class BinarySearchTree {
    // Define the Node class
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Root node of the tree
    Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    // Insert a new node into the BST
    void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive function to insert a new node in the BST
    Node insertRec(Node root, int data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // In-order Traversal (Left, Root, Right) to print the tree
    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        // Create the tree and insert nodes
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Perform In-order traversal to display the elements in sorted order
        System.out.println("In-order traversal of the BST:");
        bst.inOrder(bst.root);  // Should print the elements in sorted order
    }
}
OUTPUT :
In-order traversal of the BST:
20 30 40 50 60 70 80 

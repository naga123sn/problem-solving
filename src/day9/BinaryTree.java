package day9;
class BinaryTree {
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
    public BinaryTree() {
        root = null;
    }

    // Pre-order Traversal (Root, Left, Right)
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // In-order Traversal (Left, Root, Right)
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Post-order Traversal (Left, Right, Root)
    void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        // Create the tree and set up nodes
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        // Perform Traversals
        System.out.println("Pre-order traversal:");
        tree.preOrder(tree.root);

        System.out.println("\nIn-order traversal:");
        tree.inOrder(tree.root);

        System.out.println("\nPost-order traversal:");
        tree.postOrder(tree.root);
    }
}

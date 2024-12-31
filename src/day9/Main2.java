package day9;
// Class to represent a node in the binary tree
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

// Class to represent the binary tree
class BinaryTree {
    TreeNode root;

    // Method to calculate the height of the binary tree
    public int findHeight(TreeNode node) {
        if (node == null) {
            return -1; // Return -1 for an empty tree (or 0 if height of a single node is considered 0)
        }

        // Recursively calculate the height of left and right subtrees
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        // The height of the tree is the maximum of the two heights plus 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Create a sample binary tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);

        // Calculate and display the height of the tree
        int height = tree.findHeight(tree.root);
        System.out.println("Height of the binary tree: " + height);
    }
}

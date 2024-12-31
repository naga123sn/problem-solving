package day9;
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class SumOfTreeElements {

    // Function to sum up all the elements in the tree
    public static int sumOfElements(TreeNode root) {
        if (root == null) {
            return 0;  // Base case: if the node is null, return 0
        }

        // Recursively sum the left and right subtrees and add the current node's value
        return root.value + sumOfElements(root.left) + sumOfElements(root.right);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Calculate the sum of all elements
        int sum = sumOfElements(root);

        // Print the sum of all elements
        System.out.println("Sum of all elements in the tree: " + sum);
    }
}

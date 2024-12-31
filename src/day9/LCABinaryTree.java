package day9;
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class LCABinaryTree {

    // Function to find the LCA
    public static TreeNode findLCA(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        // If either n1 or n2 matches with the root's value, return root
        if (root.value == n1 || root.value == n2) {
            return root;
        }

        // Look for keys in left and right subtrees
        TreeNode leftLCA = findLCA(root.left, n1, n2);
        TreeNode rightLCA = findLCA(root.right, n1, n2);

        // If both left and right LCA are non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null node
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int n1 = 5, n2 = 1;
        TreeNode lca = findLCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.value);
        } else {
            System.out.println("LCA not found.");
        }
    }
}

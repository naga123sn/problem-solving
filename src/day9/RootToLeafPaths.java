package day9;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class RootToLeafPaths {
    
    // Function to find all root-to-leaf paths
    public static void findPaths(TreeNode root, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        // Add the current node to the path
        currentPath.add(root.value);

        // If it's a leaf node, add the current path to the list of all paths
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            // Otherwise, traverse both left and right subtrees
            findPaths(root.left, currentPath, allPaths);
            findPaths(root.right, currentPath, allPaths);
        }

        // Remove the current node from the path before returning to the parent node
        currentPath.remove(currentPath.size() - 1);
    }

    // Function to print the paths
    public static void printPaths(List<List<Integer>> allPaths) {
        for (List<Integer> path : allPaths) {
            System.out.println(path);
        }
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

        // List to store the current path
        List<Integer> currentPath = new ArrayList<>();
        // List to store all root-to-leaf paths
        List<List<Integer>> allPaths = new ArrayList<>();

        // Find all root-to-leaf paths
        findPaths(root, currentPath, allPaths);

        // Print the paths
        System.out.println("Root-to-Leaf Paths:");
        printPaths(allPaths);
    }
}

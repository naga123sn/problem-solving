package day7;
import java.util.Stack;

public class NextGreaterElement {
    
    // Method to find the next greater element for each element in the array
    public static void nextGreaterElement(int[] nums) {
        // Create a stack to store the indices of the elements
        Stack<Integer> stack = new Stack<>();
        
        // Initialize an array to store the result (next greater elements)
        int[] result = new int[nums.length];
        
        // Initialize result array with -1, assuming no next greater element
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // While stack is not empty and the current element is greater than the element
            // corresponding to the index at the top of the stack
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                // Pop the index from the stack and set the next greater element
                int index = stack.pop();
                result[index] = nums[i];
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        // Print the result array
        System.out.println("Next Greater Element for each element:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(nums[i] + " --> " + result[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        
        // Find and print the next greater element for each element
        nextGreaterElement(nums);
    }
}


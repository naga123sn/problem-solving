package day7;
import java.util.Stack;

public class BalancedParentheses {

    // Method to check if the parentheses are balanced
    public static boolean areParenthesesBalanced(String expression) {
        // Create a stack to store opening parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If the character is an opening parenthesis, push it to the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If the character is a closing parenthesis, check for the matching opening parenthesis
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty or the top of the stack does not match the current closing parenthesis
                if (stack.isEmpty()) {
                    return false; // No matching opening parenthesis
                }

                char top = stack.pop();
                // Check if the popped opening parenthesis matches the closing one
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false; // Mismatched parentheses
                }
            }
        }

        // If the stack is empty, the parentheses are balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expression = "{[()]}"; // Test string

        // Check if the parentheses are balanced
        if (areParenthesesBalanced(expression)) {
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
    }
}

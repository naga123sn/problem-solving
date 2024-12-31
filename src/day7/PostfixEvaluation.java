package day7;
import java.util.Stack;

public class PostfixEvaluation {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);
            
            // If the token is a digit, push it onto the stack
            if (Character.isDigit(token)) {
                stack.push(token - '0');  // Convert char to integer
            }
            // If the token is an operator, pop two operands and apply the operator
            else if (token == '+' || token == '-' || token == '*' || token == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                int result = 0;
                switch (token) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }
                
                // Push the result back onto the stack
                stack.push(result);
            }
        }
        
        // The result will be the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "23*54*+9-";  // Example postfix expression: (2 * 3) + (5 * 4) - 9
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result of the postfix expression: " + result);
    }
}


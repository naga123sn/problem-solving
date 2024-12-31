package day4;
public class FibonacciRecursive {
    public static void main(String[] args) {
        int n = 10; // You can change this value to calculate a different Fibonacci number
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base cases: fibonacci(0) = 0, fibonacci(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }
}


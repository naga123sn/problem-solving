package day1;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the limit
        System.out.print("Enter the number up to which Fibonacci numbers should be printed: ");
        int n = scanner.nextInt();

        // Print the Fibonacci series
        System.out.println("Fibonacci numbers up to " + n + ":");
        printFibonacciUpToN(n);

        scanner.close();
    }

    // Method to print Fibonacci numbers up to n
    public static void printFibonacciUpToN(int n) {
        if (n < 0) {
            System.out.println("Please enter a non-negative number.");
            return;
        }
        int first = 0, second = 1;

        // Print the first Fibonacci number if within range
        if (n >= first) {
            System.out.print(first + " ");
        }

        // Print the second Fibonacci number if within range
        if (n >= second) {
            System.out.print(second + " ");
        }

        // Calculate and print subsequent Fibonacci numbers
        int next = first + second;
        while (next <= n) {
            System.out.print(next + " ");
            first = second;
            second = next;
            next = first + second;
        }

        System.out.println(); // Move to the next line after printing
    }
}

OUTPUT :
Enter the number up to which Fibonacci numbers should be printed: 21
Fibonacci numbers up to 21:
0 1 1 2 3 5 8 13 21 



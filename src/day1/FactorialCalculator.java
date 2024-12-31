package day1;
import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();

        // Calculate factorial
        long factorial = findFactorial(number);

        // Display result
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println("The factorial of " + number + " is: " + factorial);
        }

        scanner.close();
    }

    // Method to calculate factorial
    public static long findFactorial(int num) {
        if (num < 0) {
            return -1; // Indicating that factorial is not defined for negative numbers
        }
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}

OUTPUT :
Enter a number to find its factorial: 5
The factorial of 5 is: 120


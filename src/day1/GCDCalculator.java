package day1;
import java.util.Scanner;

public class GCDCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Calculate GCD
        int gcd = findGCD(num1, num2);

        // Display the result
        System.out.println("The GCD/HCF of " + num1 + " and " + num2 + " is: " + gcd);

        scanner.close();
    }

    // Method to calculate GCD using the Euclidean algorithm
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // GCD is always positive
    }
}

OUTPUT :
Enter the first number: 22
Enter the second number: 43
The GCD/HCF of 22 and 43 is: 1


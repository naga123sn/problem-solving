package day1;
import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Calculate the sum of digits
        int sum = calculateSumOfDigits(Math.abs(number)); // Use absolute value for negative numbers

        // Display the result
        System.out.println("The sum of the digits of " + number + " is: " + sum);

        scanner.close();
    }

    // Method to calculate the sum of digits
    public static int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; // Add the last digit
            num /= 10;       // Remove the last digit
        }
        return sum;
    }
}

OUTPUT :
Enter an integer: 32
The sum of the digits of 32 is: 5


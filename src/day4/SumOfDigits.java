package day4;
public class SumOfDigits {
    public static void main(String[] args) {
        int number = 12345; // Example number
        int sum = findSumOfDigits(number);
        System.out.println("The sum of digits in " + number + " is: " + sum);
    }

    public static int findSumOfDigits(int n) {
        // Base case: If the number is 0, return 0
        if (n == 0) {
            return 0;
        }
        // Recursive case: Add the last digit to the sum of the remaining digits
        return (n % 10) + findSumOfDigits(n / 10);
    }
}


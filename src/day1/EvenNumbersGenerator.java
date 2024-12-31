package day1;
import java.util.Scanner;

public class EvenNumbersGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for the number of even numbers to generate
        System.out.print("Enter the number of even numbers to generate: ");
        int n = scanner.nextInt();
        
        System.out.println("The first " + n + " even numbers are:");
        
        for (int i = 1; i <= n; i++) {
            System.out.print((i * 2) + " ");
        }
        
        scanner.close();
    }
}

OUTPUT :
Enter the number of even numbers to generate: 5
The first 5 even numbers are:
2 4 6 8 10 

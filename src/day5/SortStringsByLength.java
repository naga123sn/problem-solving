package day5;
import java.util.Arrays;

public class SortStringsByLength {
    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "kiwi", "cherry", "mango"};

        // Sort the array by length
        Arrays.sort(strings, (a, b) -> Integer.compare(a.length(), b.length()));

        // Print the sorted array
        System.out.println("Strings sorted by length: " + Arrays.toString(strings));
    }
}

package day4;
import java.util.ArrayList;
import java.util.List;

public class ParenthesesCombinations {

    public static void main(String[] args) {
        int n = 3; // Number of pairs of parentheses
        List<String> combinations = generateParentheses(n);
        System.out.println("Valid combinations of parentheses:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, "", 0, 0, n);
        return result;
    }

    private static void generateParenthesesHelper(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generateParenthesesHelper(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            generateParenthesesHelper(result, current + ")", open, close + 1, max);
        }
    }
}

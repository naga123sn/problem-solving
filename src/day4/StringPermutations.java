package day4;
import java.util.HashSet;
import java.util.Set;

public class StringPermutations {

    public static void main(String[] args) {
        String input = "ABC";
        System.out.println("All permutations of the string \"" + input + "\":");
        Set<String> permutations = getPermutations(input);
        
        // Print all unique permutations
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static Set<String> getPermutations(String str) {
        Set<String> result = new HashSet<>();  // Using a Set to avoid duplicates
        generatePermutations(str, "", result);
        return result;
    }

    private static void generatePermutations(String str, String current, Set<String> result) {
        // Base case: If the string is empty, add the current string to result
        if (str.length() == 0) {
            result.add(current);
            return;
        }

        // Recur for each character in the string
        for (int i = 0; i < str.length(); i++) {
            // Choose the current character and remove it from the remaining string
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);

            // Recur with the remaining string and the current character added to the current permutation
            generatePermutations(remaining, current + ch, result);
        }
    }
}


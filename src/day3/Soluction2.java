package day3;
import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        // Step 1: Count the frequency of each character in the string
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Step 2: Traverse the string to find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first non-repeating character
            }
        }
        
        // Step 3: If no non-repeating character found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        System.out.println(solution.firstUniqChar(s)); // Output: 0
    }
}

package day4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the candidates to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, 
                           int[] candidates, int target, int start) {
        // Base case: if the target is zero, we've found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));  // Add a copy of current combination to the result
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // If the current candidate is greater than the target, no need to continue
            if (candidates[i] > target) {
                break;
            }
            
            // Include the current candidate and move to the next
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i + 1);
            current.remove(current.size() - 1);  // Backtrack: remove the last added element
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 5};
        int target = 8;
        List<List<Integer>> combinations = solution.combinationSum2(candidates, target);
        System.out.println(combinations);  // Output: [[1, 2, 5], [1, 7], [2, 6]]
    }
}

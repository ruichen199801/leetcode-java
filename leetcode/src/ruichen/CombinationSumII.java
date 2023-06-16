package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    // TC = O(2^n) (choose or not choose), SC = O(n), where n: candidate size
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates); // sort the array to handle duplicates
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            dfs(candidates, target, res, curr, 0);
            return res;
        }

        private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int start) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                // If the current number is the same as the previous number and is not the first number of this level of loop
                // (i.e. i > start), we skip this number to avoid duplicate combinations.
                // Example: n=[2a,2b,2c], t=4 should not give [2a,2b],[2b,2c].
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curr.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, curr, i + 1); // i+1: make sure each number is chosen once
                curr.remove(curr.size() - 1);
            }
        }
    }
}

package ruichen;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // Coin Change DFS: 4^99 vs 99^4
    // Assumption: distinct integers
    class Solution1 {
        // 4^99 solution (not so good): TC = O(n^t), SC = O(t), where n: candidate size, t: target
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            // use the start index to avoid duplicates
            for (int i = start; i < candidates.length; i++) {
                curr.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, curr, i);
                curr.remove(curr.size() - 1);
            }
        }
    }

    class Solution2 {
        // 99^4 solution (better): TC = O(t^n), SC = O(n), where n: candidate size, t: target
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            dfs(candidates, target, res, curr, 0);
            return res;
        }

        private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int index) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }
            // target > 0 && index out of bound
            if (index == candidates.length) {
                return;
            }
            // try each possibility from 0 to target / candidates[index]
            for (int i = 0; i <= target / candidates[index]; i++) {
                // add candidates[index] into curr exactly i times
                for (int j = 0; j < i; j++) {
                    curr.add(candidates[index]);
                }
                dfs(candidates, target - i * candidates[index], res, curr, index + 1);
                // remove candidates[index] from curr exactly i times
                for (int j = 0; j < i; j++) {
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}

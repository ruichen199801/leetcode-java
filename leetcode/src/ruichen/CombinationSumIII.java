package ruichen;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    // TC = P(9, k) * k: 9 choose k, copy result takes O(k)
    // SC = O(k): recursion and result list both take O(k)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            dfs(k, n, res, curr, 1, 0);
            // index: skip duplicates (1 -> 9)
            // level: make sure k numbers used (0 -> k-1)
            return res;
        }

        private void dfs(int k, int n, List<List<Integer>> res, List<Integer> curr, int index, int level) {
            if (n < 0 || level > k) {
                return;
            }
            if (level == k && n == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }
            for (int i = index; i <= 9; i++) {
                curr.add(i);
                dfs(k, n - i, res, curr, i + 1, level + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

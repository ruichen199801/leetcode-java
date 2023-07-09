package ruichen;

import java.util.*;

public class PermutationsII {
    // TC = O(n! * n)
    // SC = O(n) for recursion + O(n) for storing results along the way;
    // If we take into account the space needed to hold the results, SC = O(n! * n)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums); // sort the array to handle duplicates
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            dfs(nums, res, curr, used);
            return res;
        }

        private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] used) {
            if (curr.size() == nums.length) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                    continue; // skip duplicates
                }

                curr.add(nums[i]);
                used[i] = true;
                dfs(nums, res, curr, used);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
}

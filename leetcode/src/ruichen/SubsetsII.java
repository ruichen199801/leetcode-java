package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    // TC = O(2^ * n), SC = O(n)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums); // sort the array to handle duplicates
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            dfs(nums, res, curr, 0);
            return res;
        }

        private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
            res.add(new ArrayList<>(curr));

            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i - 1] == nums[i]) {
                    continue; // skip duplicates
                }

                curr.add(nums[i]);
                dfs(nums, res, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

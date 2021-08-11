package ruichen;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // #46 https://leetcode.com/problems/permutations/
    // Depth-first Search

    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            //                     [1  2  3]
            //                    /    |    \             3 branches
            // index == 0        1     2     3
            //                  / \   / \   / \           2 branches
            //          1      2   3 1   3 1   2
            //                 |   | |   | |   |          1 branch
            //          2      3   2 3   1 2   1
            // output    [123] [132] [213] [231] [312] [321]

            // Time complexity = O(n * (n-1) * .. * 1) * O(n) (deep copy) = O(n * n!) for n numbers in input array
            // Space Complexity = O(n) for recursion + O(n) for storing results along the way;
            // if we take into account the space needed to hold the results, SC = O(n! * n)

            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            List<Integer> curr = new ArrayList<>();
            boolean[] used = new boolean[nums.length]; // de-dup
            helper(nums, used, curr, result);
            return result;
        }

        private void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result) {
            if (curr.size() == nums.length) {
                result.add(new ArrayList<>(curr)); // deep copy
                return;
            }
            // loop to decide add which one of the three numbers in each level
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    curr.add(nums[i]);
                    helper(nums, used, curr, result);
                    used[i] = false;
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}

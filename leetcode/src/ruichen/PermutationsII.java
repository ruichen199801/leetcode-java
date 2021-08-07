package ruichen;

import java.util.*;

public class PermutationsII {

    // #47 https://leetcode.com/problems/permutations-ii/
    // Depth-first Search
    // TC = O(n! * n), SC = O(n)

    class Solution1 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            // to get around duplicates:
            // method 1: use a set instead of an arraylist as result
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> curr = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            helper(nums, used, curr, result);
            return new ArrayList<>(result);
        }

        private void helper(int[] nums, boolean[] used, List<Integer> curr, Set<List<Integer>> result) {
            if (curr.size() == nums.length) {
                result.add(new ArrayList<>(curr));
                return;
            }
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

    class Solution2 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            // method 2: sort the input array, use pointer to skip duplicates (see #90)
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> curr = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            helper(nums, used, curr, result);
            return new ArrayList<>(result);
        }

        private void helper(int[] nums, boolean[] used, List<Integer> curr, Set<List<Integer>> result) {
            if (curr.size() == nums.length) {
                result.add(new ArrayList<>(curr));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    curr.add(nums[i]);
                    helper(nums, used, curr, result);
                    used[i] = false;
                    curr.remove(curr.size() - 1);
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
        }
    }
}

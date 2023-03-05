package ruichen;

import java.util.*;

public class PermutationsII {
    // TC = O(n! * n)
    // SC = O(n) for recursion + O(n) for storing results along the way;
    // If we take into account the space needed to hold the results, SC = O(n! * n)
    class Solution1 {
        // To get around duplicates: Method 1: use a set instead of an arraylist as result
        public List<List<Integer>> permuteUnique(int[] nums) {

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
        // Method 2: sort the input array, use pointer to skip duplicates (see #90)
        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            helper(nums, used, new ArrayList<>(), result);
            return result;
        }

        private void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result) {
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

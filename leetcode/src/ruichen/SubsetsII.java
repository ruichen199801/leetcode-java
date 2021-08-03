package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    // #90 https://leetcode.com/problems/subsets-ii/
    // Depth-first Search
    // TC = O(2^ * n), SC = O(n) (Java's Arrays.sort: variant of quick sort, O(log n))

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums); // sort the input array to put duplicates together
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            helper(nums, 0, curr, result);
            return result;
        }

        private void helper(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {
            if (index == nums.length) {
                result.add(new ArrayList<>(curr));
                return;
            }
            // case 1: add the current element
            curr.add(nums[index]);
            helper(nums, index + 1, curr, result);
            curr.remove(curr.size() - 1);

            // skip duplicates
            while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
                index++;
            }

            // case 2: not add the current element
            helper(nums, index + 1, curr, result);
        }
    }
}

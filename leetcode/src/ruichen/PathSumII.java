package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    // DFS
    // TC = O(n^2) For n/2 leaves at worst, each deep copy to the result list costs O(n), so n/2 * O(n) = O(n^2)
    // SC = O(n) for the curr list (additional space we use, result list doesn't count)
    // No BFS: too much space overhead, need a huge queue size
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            helper(root, targetSum, curr, result);
            return result;
        }

        private void helper(TreeNode root, int targetSum, List<Integer> curr, List<List<Integer>> result) {
            // base case
            if (root == null) {
                return;
            }
            curr.add(root.val);
            // reach leaf
            if (root.left == null && root.right == null && root.val == targetSum) {
                result.add(new ArrayList<>(curr)); // Java param passing: must deep copy which takes O(n)!
            } else {
                helper(root.left, targetSum - root.val, curr, result);
                helper(root.right, targetSum - root.val, curr, result);
            }
            curr.remove(curr.size() - 1); // must pop the node once we're done processing all of its subtrees!
        }
    }
}

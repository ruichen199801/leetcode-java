package ruichen;

import ruichen.common.TreeNode;

public class PathSum {
    // TC = O(n), SC = O(log n) in average, O(n) worst case, n = # of nodes
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                return true;
            } else {
                return hasPathSum(root.left, targetSum - root.val)
                        || hasPathSum(root.right, targetSum - root.val);
            }
        }
    }
}

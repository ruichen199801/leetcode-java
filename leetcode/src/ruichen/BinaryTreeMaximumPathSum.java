package ruichen;

import ruichen.common.TreeNode;

public class BinaryTreeMaximumPathSum {
    // TC = O(n), SC = O(height)
    class Solution {
        public int maxPathSum(TreeNode root) {
            int[] max = {Integer.MIN_VALUE};
            helper(root, max);
            return max[0];
        }

        private int helper(TreeNode root, int[] max) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(0, helper(root.left, max));
            int right = Math.max(0, helper(root.right, max));
            max[0] = Math.max(max[0], left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
}

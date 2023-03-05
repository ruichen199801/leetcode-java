package ruichen;

import ruichen.common.TreeNode;

public class SumOfLeftLeaves {
    // TC = O(n), SC = O(height), O(n) worst case
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int[] sum = {0};
            helper(root, sum);
            return sum[0];
        }

        private void helper(TreeNode root, int[] sum) {
            if (root == null) {
                return;
            }
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum[0] += root.left.val;
            }
            helper(root.left, sum);
            helper(root.right, sum);
        }
    }
}

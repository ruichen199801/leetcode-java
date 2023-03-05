package ruichen;

import ruichen.common.TreeNode;

public class SumRootToLeafNumbers {
    // TC = O(n), SC = O(height)
    class Solution {
        public int sumNumbers(TreeNode root) {
            int[] sum = {0};
            helper(root, 0, sum);
            return sum[0];
        }

        private void helper(TreeNode root, int cur, int[] sum) {
            if (root == null) {
                return;
            }
            // add to sum only when reaching leaf
            if (root.left == null && root.right == null) {
                sum[0] += 10 * cur + root.val;
                return;
            }
            helper(root.left, 10 * cur + root.val, sum);
            helper(root.right, 10 * cur + root.val, sum);
        }
    }
}

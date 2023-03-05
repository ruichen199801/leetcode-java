package ruichen;

import ruichen.common.TreeNode;

public class UnivaluedBinaryTree {
    // TC = O(n), SC = O(height)
    class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return false;
            }
            int[] value = {root.val};
            return helper(root, value);
        }

        private boolean helper(TreeNode root, int[] value) {
            if (root == null) {
                return true;
            }
            if (root.val != value[0]) {
                return false;
            }
            return helper(root.left, value) && helper(root.right, value);
        }
    }
}

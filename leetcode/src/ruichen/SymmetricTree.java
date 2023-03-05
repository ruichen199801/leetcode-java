package ruichen;

import ruichen.common.TreeNode;

public class SymmetricTree {
    // TC = O(n), SC = O(height)
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) &&
                    isSymmetric(left.right, right.left);
        }
    }
}

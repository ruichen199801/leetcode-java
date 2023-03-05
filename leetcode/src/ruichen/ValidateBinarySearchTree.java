package ruichen;

import ruichen.common.TreeNode;

public class ValidateBinarySearchTree {
    // TC = O(n), SC = O(height)
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBSTHelper(root, null, null);
        }

        private boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
            if (node == null) {
                return true;
            }

            if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
                return false;
            }

            return isValidBSTHelper(node.left, min, node.val)
                    && isValidBSTHelper(node.right, node.val, max);
        }
    }
}

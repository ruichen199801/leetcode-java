package ruichen;

import ruichen.common.TreeNode;

public class EvaluateBooleanBinaryTree {
    // TC = O(n), SC = O(height)
    class Solution {
        public boolean evaluateTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left == null && root.right == null) {
                return root.val == 1;
            }
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            return root.val == 2 ? left || right : left && right;
        }
    }
}

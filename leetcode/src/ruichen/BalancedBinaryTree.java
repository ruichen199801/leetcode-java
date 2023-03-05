package ruichen;

import ruichen.common.TreeNode;

public class BalancedBinaryTree {
    class Solution1 {
        // TC = O(nlog n), SC = O(height)
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            if (Math.abs(left - right) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    class Solution2 {
        // Better: TC = O(n), SC = O(height)
        // use -1 to denote the tree is not balanced
        // >= 0 value means the tree is balanced and it is the height of the tree
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return height(root) != -1;
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // if left subtree is already not balanced, we do not need to continue calculating its height, and we can return -1 directly
            int left = height(root.left);
            if (left == -1) {
                return -1;
            }
            int right = height(root.right);
            if (right == -1) {
                return -1;
            }
            // if not balanced, return -1
            if (Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }
}

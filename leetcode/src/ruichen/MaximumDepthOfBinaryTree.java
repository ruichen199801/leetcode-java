package ruichen;

import ruichen.common.TreeNode;

public class MaximumDepthOfBinaryTree {
    // TC = O(n), SC = O(height)
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}

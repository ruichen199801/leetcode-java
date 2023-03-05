package ruichen;

import ruichen.common.TreeNode;

public class DiameterOfBinaryTree {
    // TC = O(n), SC = O(height)
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            int[] max = {0};
            helper(root, max);
            return max[0];
        }

        private int helper(TreeNode root, int[] max) {
            if (root == null) {
                return 0;
            }
            // Step 1: ask for children nodes
            int left = helper(root.left, max);
            int right = helper(root.right, max);
            // Step 2: what to do at the current layer
            max[0] = Math.max(max[0], left + right);
            // Step 3: what to return/pass to parent nodes
            return Math.max(left, right) + 1;
        }
    }
}

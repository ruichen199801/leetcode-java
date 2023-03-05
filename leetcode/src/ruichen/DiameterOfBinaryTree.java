package ruichen;

public class DiameterOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        // #543 https://leetcode.com/problems/diameter-of-binary-tree/
        // Tree
        // TC = O(n), SC = O(height)

        public int diameterOfBinaryTree(TreeNode root) {
            // Diameter = max number of nodes in a path - 1
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

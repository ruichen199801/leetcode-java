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
            // diameter = max number of nodes in a path - 1
            int[] max = {Integer.MIN_VALUE};
            getHeight(root, max);
            return max[0] - 1;
        }

        private int getHeight(TreeNode root, int[] max) {
            // update max and recursively get height at the same time
            if (root == null) {
                return 0;
            }
            int left = getHeight(root.left, max);
            int right = getHeight(root.right, max);
            max[0] = Math.max(max[0], left + right + 1);
            return Math.max(left, right) + 1;
        }
    }
}
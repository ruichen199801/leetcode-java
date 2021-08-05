package ruichen;

public class PathSum {

    // #112 https://leetcode.com/problems/path-sum/
    // Tree, Depth-first Search
    // TC = O(n), SC = O(log n) in average, O(n) worst case, n = # of nodes

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                return true;
            } else {
                return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
            }
        }
    }
}

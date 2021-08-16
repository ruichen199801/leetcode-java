package ruichen;

public class SumRootToLeafNumbers {

    // #129 https://leetcode.com/problems/sum-root-to-leaf-numbers/
    // Tree, Recursion, Depth-first Search
    // TC = O(n), SC = O(height)

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
        public int sumNumbers(TreeNode root) {
            int[] sum = {0};
            helper(root, 0, sum);
            return sum[0];
        }

        private void helper(TreeNode root, int cur, int[] sum) {
            if (root == null) {
                return;
            }
            // add to sum only when reaching leaf
            if (root.left == null && root.right == null) {
                sum[0] += 10 * cur + root.val;
                return;
            }
            helper(root.left, 10 * cur + root.val, sum);
            helper(root.right, 10 * cur + root.val, sum);
        }
    }
}

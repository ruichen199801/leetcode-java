package ruichen;

import ruichen.common.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    // For any two adjacent nodes in an inorder traversal, their difference
    // will be the smallest among all possible pairs of nodes.

    // TC = O(n), SC = O(height)
    class Solution {
        public int minDiffInBST(TreeNode root) {
            int[] res = {Integer.MAX_VALUE, Integer.MAX_VALUE}; // Store minDiff, prev
            dfs(root, res);
            return res[0];
        }

        private void dfs(TreeNode root, int[] res) {
            if (root == null) {
                return;
            }
            dfs(root.left, res);

            if (res[1] != Integer.MAX_VALUE) {
                res[0] = Math.min(res[0], root.val - res[1]); // We don't need Math.abs()
            }
            res[1] = root.val;

            dfs(root.right, res);
        }
    }
}

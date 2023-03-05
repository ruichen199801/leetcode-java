package ruichen;

import ruichen.common.TreeNode;

public class MinimumDepthOfBinaryTree {
    // Skip Math.min comparison when node is null to handle the case below:
    //  3
    //   \
    //    4
    //     \
    //      5
    //       \
    //        6

    // TC = O(n), SC = O(height)
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null) {
                return minDepth(root.right) + 1;
            }
            if (root.right == null) {
                return minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}

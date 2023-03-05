package ruichen;

import ruichen.common.TreeNode;

public class InvertBinaryTree {
    //    root
    //    /  \
    // -----------
    // left right (already recursively reversed)
    // what's left to do? root.left = right, root.right = left

    // TC = O(n), SC = O(height)
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}

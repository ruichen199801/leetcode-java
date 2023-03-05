package ruichen;

import ruichen.common.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    // TC = O(n), SC = O(n)
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);

        // Assume current node's left and right children are already flattened
        // preorder: node -> left -> right
        // TODO1: node -> left
        // TODO2: left -> right
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left; // TODO1

        // move cur node to left's tail
        while (root.right != null) {
            root = root.right;
        }
        root.right = right; // TODO2
    }
}

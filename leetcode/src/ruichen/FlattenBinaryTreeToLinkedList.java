package ruichen;

public class FlattenBinaryTreeToLinkedList {

    // #114 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    // Tree, Depth-first Search
    // TC = O(n), SC = O(n)

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

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

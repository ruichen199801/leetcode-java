package ruichen;

public class LowestCommonAncestorOfABinaryTreeII {

    // #1644 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/
    // Tree, Depth-first Search
    // TC = O(n), SC = O(h)

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

        int count = 0; // https://stackoverflow.com/questions/32909167/changing-the-value-of-a-primitive-variable-in-a-method

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            TreeNode result = helper(root, p, q);
            return count == 2 ? result : null;
        }

        private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // cannot return early in case 2 & 3 (count == 1, always return null), must traverse every node to guarantee p & q are both in the tree
            // thus change the order of line 31-34 to be after we've finished the recursion calls
            TreeNode left = helper(root.left, p, q);
            TreeNode right = helper(root.right, p, q);
            if (root == p || root == q) {
                count++;
                return root;
            }
            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            return null;
            // return left == null ? right : right == null ? left : root;
        }
    }
}

package ruichen;

public class LowestCommonAncestorOfABinarySearchTree {

    // #235 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    // Tree, Depth-first Search

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

    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // Different from a normal binary tree, we can compare the node's value to shrink search range to left or right subtree
            // p < root < q: return root (similar to mid pointer in binary search)
            // root > p, q: go left
            // root < p, q: go right

            // iterative: TC = O(n), SC = O(1)
            while (root != null) {
                if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                } else if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else {
                    return root;
                }
            }
            return null;
        }
    }

    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // recursive: TC = O(n), SC = O(n)
            if (root == null) {
                return null;
            }
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}

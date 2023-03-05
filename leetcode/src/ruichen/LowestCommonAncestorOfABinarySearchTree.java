package ruichen;

import ruichen.common.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    // Different from a normal binary tree, we can compare the node's value to shrink search range to left or right subtree
    // p < root < q: return root (similar to mid pointer in binary search)
    // root > p, q: go left
    // root < p, q: go right
    class Solution1 {
        // Iterative: TC = O(n), SC = O(1)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
        // Recursive: TC = O(n), SC = O(n)
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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

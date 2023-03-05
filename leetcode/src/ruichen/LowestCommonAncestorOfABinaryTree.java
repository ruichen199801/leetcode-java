package ruichen;

import ruichen.common.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    //   Case 1        Case 2        Case 3
    //    root          root          root
    //   /    \         /   \         /   \
    //  p      q      p/q  null     null  p/q

    //     root
    //     / \
    //    x   x
    //   / \ / \
    //  p  x q  x

    // Post-order traversal: time complexity = O(n), space complexity = O(log n) in average and O(n) for a skewed tree
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // base case: return if reach bottom or p/q is found
            if (root == null) {
                return null;
            }
            if (root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // Case 1
            if (left != null && right != null) {
                return root;
            }
            // Case 2
            if (left != null) {
                return left;
            }
            // Case 3
            if (right != null) {
                return right;
            }
            // p, q not found in input tree
            return null;
        }
    }
}

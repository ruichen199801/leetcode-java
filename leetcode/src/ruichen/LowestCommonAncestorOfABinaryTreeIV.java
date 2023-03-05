package ruichen;

import ruichen.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeIV {
    // Same as #236, build a hashset for O(1) lookup
    // TC = O(n), SC = O(h) on stack + O(m) on heap for finding LCA of m nodes
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            Set<TreeNode> set = new HashSet<>();
            for (TreeNode node : nodes) {
                set.add(node);
            }
            return helper(root, set);
        }

        private TreeNode helper(TreeNode root, Set<TreeNode> set) {
            if (root == null) {
                return null;
            }
            if (set.contains(root)) {
                return root; // O(1)
            }
            TreeNode left = helper(root.left, set);
            TreeNode right = helper(root.right, set);
            if (left != null && right != null) {
                return root;
            }
            return left != null ? left : right; // based on the assumption that all nodes are on the input tree, so we'll never get null
        }
    }
}

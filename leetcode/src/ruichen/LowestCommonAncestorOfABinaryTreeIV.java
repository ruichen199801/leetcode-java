package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeIV {

    // #1676 https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
    // Tree, Depth-first Search
    // TC = O(n), SC = O(h) on stack + O(m) on heap for finding LCA of m nodes

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
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            // same as #236, build a hashset for O(1) lookup
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

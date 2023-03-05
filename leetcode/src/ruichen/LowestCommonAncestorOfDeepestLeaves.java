package ruichen;

import ruichen.common.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves {
    // Same as: #865
    class Solution1 {
        // TC = O(n^2), expensive because we compute height for every node, SC = O(n)
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if (root == null) {
                return null;
            }
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (leftHeight == rightHeight) {
                return root;
            }
            return leftHeight > rightHeight ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        }
    }

    class Solution2 {
        // TC = O(n), SC = O(h)
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            Pair p = helper(root, 0); // get LCA, pass Pair instead of TreeNode between tree levels -> one pass, O(n)
            return p.node;
        }

        private Pair helper(TreeNode root, int d) {
            if (root == null) {
                return new Pair(null, d);
            }
            Pair left = helper(root.left, d + 1);
            Pair right = helper(root.right, d + 1);
            if (left.d == right.d) {
                return new Pair(root, left.d);
            }
            return left.d > right.d ? left : right;
        }

        class Pair {
            TreeNode node;
            int d;

            public Pair(TreeNode node, int d) {
                this.node = node;
                this.d = d;
            }
        }
    }
}

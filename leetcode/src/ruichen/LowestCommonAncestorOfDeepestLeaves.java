package ruichen;

public class LowestCommonAncestorOfDeepestLeaves {

    // #1123 https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
    // Same as: #865 https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
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
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            // TC = O(n^2), expensive b/c we compute height for every node, SC = O(n)
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
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            // TC = O(n), SC = O(h)
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

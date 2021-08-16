package ruichen;

public class MergeTwoBinaryTrees {

    // #617 https://leetcode.com/problems/merge-two-binary-trees/
    // Tree, Depth-first Search
    // TC = O(n), n = # of nodes in root1 and root2, SC = O(h)

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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

            // case 1: root1 is null + root2 is null: return null
            // case 2: root1 is null + root2 is not null: return root2
            // case 3: root1 is not null + root2 is null: return root1
            // case 4: both are not null: root1.val + root2.val
            // we fabricate the result tree by creating nodes using "new" and
            // creating branches to connect the nodes by dereferening using
            // ".left" and ".right"

            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            TreeNode result = new TreeNode(root1.val + root2.val);
            result.left = mergeTrees(root1.left, root2.left);
            result.right = mergeTrees(root1.right, root2.right);
            return result;
        }
    }
}

package ruichen;

import ruichen.common.TreeNode;

public class InsertIntoABinarySearchTree {
    class Solution1 {
        // Recursive: TC = O(h), SC = O(h), see #108
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val); // reach bottom, prepare to-be-inserted node to return to last level
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val); // insert in left
            } else {
                root.right = insertIntoBST(root.right, val); // or insert in right
            }
            return root;
        }
    }

    class Solution2 {
        // Iterative: TC = O(h), SC = O(1)
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode cur = root; // don't lose control of root
            while (cur != null) {
                if (cur.val > val) {
                    if (cur.left == null) {
                        cur.left = new TreeNode(val);
                        return root;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if (cur.right == null) {
                        cur.right = new TreeNode(val);
                        return root;
                    } else {
                        cur = cur.right;
                    }
                }
            }
            return new TreeNode(val);
        }
    }
}

package ruichen;

public class InsertIntoABinarySearchTree {

    // #701 https://leetcode.com/problems/insert-into-a-binary-search-tree/
    // Tree, Binary Search Tree

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution1 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // Recursive: TC = O(h), SC = O(h)
            // #108
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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            // Iterative: TC = O(h), SC = O(1)
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

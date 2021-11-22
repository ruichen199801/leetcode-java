package ruichen;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {

    // #230 https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    // Tree, Binary Search Tree, Depth-first Search

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            // inorder traversal of BST: ascending array
            // recursive: TC = O(n), SC = O(n)
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res.get(k - 1);
        }

        private void inorder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            inorder(root.left, res);
            res.add(root.val);
            inorder(root.right, res);
        }
    }
}

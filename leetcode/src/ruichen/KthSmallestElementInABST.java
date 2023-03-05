package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {
    // Inorder traversal of BST: ascending array
    // Recursive: TC = O(n), SC = O(n)
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
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

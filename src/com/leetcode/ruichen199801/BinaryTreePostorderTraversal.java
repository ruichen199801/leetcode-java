package com.leetcode.ruichen199801;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    // #145 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
    // Tree

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        // Recursive Solution
        // TC = O(# of nodes) = O(n)
        // SC = O(height) = O(log n) in average, O(n) at worst
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }

}

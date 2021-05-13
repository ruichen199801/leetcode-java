package com.leetcode.ruichen199801;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

    // #589 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
    // Tree

    class Node {
        int val;
        List<Node> children;
        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    class Solution {
        // Recursive Solution: TC = O(n), SC = O(n) at worst
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            for (Node node: root.children) {
                helper(node, res);
            }
        }
    }
}

package ruichen;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {

    // #590 https://leetcode.com/problems/n-ary-tree-postorder-traversal/
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
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            helper(root, res);
            return res;
        }

        private void helper(Node root, List<Integer> res) {
            if (root == null) {
                return;
            }
            for (Node node: root.children) {
                helper(node, res);
            }
            res.add(root.val);
        }
    }
}

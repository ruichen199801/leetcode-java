package ruichen;

import ruichen.common.Node;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    // Recursive Solution: TC = O(n), SC = O(n) at worst
    class Solution {
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

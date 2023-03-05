package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    // Recursive Solution
    // TC = O(# of nodes) = O(n)
    // SC = O(height) = O(log n) in average, O(n) at worst
    class Solution {
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

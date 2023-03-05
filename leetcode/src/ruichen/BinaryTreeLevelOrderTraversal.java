package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // TC = O(n), SC = O(m), where n = # of nodes, m = max # of nodes at any level in the input tree
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> curr = new ArrayList<>(); // store nodes for current layer
                for (int i = 0; i < size; i++) { // each iteration represents a tree layer
                    TreeNode node = queue.poll();
                    curr.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(curr);
            }
            return result;
        }
    }
}

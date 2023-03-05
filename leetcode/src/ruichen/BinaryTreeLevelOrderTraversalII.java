package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    // TC = O(n), SC = O(m), where n = # of nodes, m = max # of nodes at any level in the input tree
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            Deque<List<Integer>> temp = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> curr = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    curr.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                temp.offerFirst(curr);
            }
            while (!temp.isEmpty()) {
                result.add(temp.pollFirst());
            }
            return result;
        }
    }
}

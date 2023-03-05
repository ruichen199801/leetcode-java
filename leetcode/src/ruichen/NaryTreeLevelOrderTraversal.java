package ruichen;

import ruichen.common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    class Solution1 {
        // BFS: TC = O(n), SC = O(n)
        // Each node is getting added to the queue, removed from the queue, and added to the result exactly once.
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> curr = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    curr.add(node.val);
                    for (Node child : node.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
                result.add(curr);
            }
            return result;
        }
    }

    class Solution2 {
        // Recursion: TC = O(n) for n nodes, SC = O(logn) average case and O(n) worst case (runtime stack)
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            helper(root, 0, result);
            return result;
        }

        private void helper(Node root, int level, List<List<Integer>> result) {
            if (level == result.size()) {
                result.add(new ArrayList<>());
                result.get(level).add(root.val);
                for (Node child : root.children) {
                    if (child != null) {
                        helper(child, level + 1, result);
                    }
                }
            }
        }
    }
}

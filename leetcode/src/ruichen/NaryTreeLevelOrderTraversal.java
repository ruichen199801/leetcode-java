package ruichen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

    // #429 https://leetcode.com/problems/n-ary-tree-level-order-traversal/
    // Tree, Breadth-first Search

    class Node {
        int val;
        List<Node> children;

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    class Solution1 {
        public List<List<Integer>> levelOrder(Node root) {

            // BFS

            // Space complexity analysis -- O(n) (for reference)
            // We are using a queue to keep track of nodes we still need to visit the children of.
            // At most, the queue will have 2 layers of the tree on it at any given time.
            // In the worst case, this is all of the nodes. In the best case, it is just 1 node (if we have a tree that is equivalent to a linked list).
            // The average case is difficult to calculate without knowing something of the trees we can expect to see,
            // but in balanced trees, half or more of the nodes are often in the lowest 2 layers.
            // So we should go with the worst case of O(n), and know that the average case is probably similar.

            // Time complexity analysis -- O(n)
            // Each node is getting added to the queue, removed from the queue, and added to the result exactly once.

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
        public List<List<Integer>> levelOrder(Node root) {

            // Recursion

            // We can use recursion for this problem. Often we can't use recursion for a breadth-first search
            // (which is what a level-order traversal is). That is because breadth-first search is based on using a queue,
            // whereas recursion is using the runtime stack and so is suited to depth-first search.
            // In this case, however, we are putting all the values into a list before returning it.
            // This means it's okay for us to get them in a different order to what they'll appear in the final list.
            // As long as we know what level each node is from, and ensure they are in the correct order within each level, it will work.
            // In industry: the iterative way (BFS) is preferred.

            // TC = O(n) for n nodes, SC = O(logn) average case and O(n) worst case (runtime stack)

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

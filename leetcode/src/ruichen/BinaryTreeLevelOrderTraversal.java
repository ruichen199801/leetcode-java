package ruichen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    // #102 (same as #107, #429, #637) https://leetcode.com/problems/binary-tree-level-order-traversal/
    // Tree, Breadth-first Search
    // TC = O(n), SC = O(m), where n = # of nodes, m = max # of nodes at any level in the input tree

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            // BFS's iterative implementation
            // typical process of a BFS:
            // maintain a queue -> initial state (enqueue the root) -> process layer by layer, dequeue a node and enqueue its left and right child
            // -> terminate when queue is empty
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result; // return an empty list in the corner case
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) { // each iteration represents a tree layer
                int size = queue.size();
                List<Integer> curr = new ArrayList<>(); // store nodes for current layer
                for (int i = 0; i < size; i++) { // each iteration represents a node on a certain layer
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

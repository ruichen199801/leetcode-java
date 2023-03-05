package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    // Normal append: offerLast, normal pop: pollLast
    // Insert at head: offerFirst, pop first element: pollFirst
    // TC = O(n), SC = O(n)
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> deque = new ArrayDeque<>();
            int layer = 0;
            deque.offerFirst(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> cur = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if (layer == 0) {
                        TreeNode node = deque.pollLast();
                        cur.add(node.val);
                        if (node.left != null) {
                            deque.offerFirst(node.left);
                        }
                        if (node.right != null) {
                            deque.offerFirst(node.right);
                        }
                    } else {
                        TreeNode node = deque.pollFirst();
                        cur.add(node.val);
                        if (node.right != null) {
                            deque.offerLast(node.right);
                        }
                        if (node.left != null) {
                            deque.offerLast(node.left);
                        }
                    }
                }
                result.add(new ArrayList<>(cur));
                layer = 1 - layer;
            }
            return result;
        }
    }
}

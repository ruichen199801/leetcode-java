package ruichen;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    // #314 https://leetcode.com/problems/binary-tree-vertical-order-traversal/
    // Tree, Breadth-first Search, Hash Table
    // TC = O(n log n) (while loop * map.put()), SC = O(n) (queue + map)

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            // compute column offset to root, print nodes ordered by their associated column
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new ArrayDeque<>();
            Queue<Integer> cols = new ArrayDeque<>();
            queue.offer(root);
            cols.offer(0);

            int minCol = 0, maxCol = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                int col = cols.poll();

                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    cols.offer(col - 1);
                    minCol = Math.min(minCol, col - 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    cols.offer(col + 1);
                    maxCol = Math.max(maxCol, col + 1);
                }
            }

            for (int i = minCol; i <= maxCol; i++) {
                result.add(map.get(i));
            }
            return result;
        }
    }
}

package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    class Solution1 {
        // DFS: traverse right first, then left
        // TC = O(n), SC = O(h) (worst case: skewed tree)
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            helper(root, 0, result);
            return result;
        }

        private void helper(TreeNode root, int index, List<Integer> result) {
            /*
            We add one rightmost element per level. There is no need to return, the program ends when
            all nodes are traversed, and we only add to result when # of levels = # of elements in list.
            */
            if (index == result.size()) {
                result.add(root.val);
            }
            // dfs starts from right to add rightmost elements
            if (root.right != null) {
                helper(root.right, index + 1, result);
            }
            if (root.left != null) {
                helper(root.left, index + 1, result);
            }
        }
    }

    class Solution2 {
        // BFS: return a list of last elements from all levels
        // TC = O(n), SC = O(n) (worst case: complete tree)
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size(); // # of nodes on each level
                for (int i = 0; i < size; i++) {
                    // only add to result if it's the last element on each level
                    TreeNode cur = queue.poll();
                    if (i == size - 1) {
                        result.add(cur.val);
                    }
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
            }
            return result;
        }
    }
}

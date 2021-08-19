package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class LinkedListInBinaryTree {

    // #1367 https://leetcode.com/problems/linked-list-in-binary-tree/
    // Tree, Linked List, Depth-first Search, Breadth-first Search
    // TC = O(N * min(L, H)), SC = O(H)
    // N = # of nodes in the tree, H = height of the tree, L = length of linked list

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution1 {
        // DFS + BFS: DFS to summarize results of boolean checks + BFS to do the check (Not recommended)
        public boolean isSubPath(ListNode head, TreeNode root) {
            return dfs(head, root);
        }

        private boolean dfs(ListNode head, TreeNode root) {
            if (root == null) {
                return false;
            }
            // if current path contains linked list, end dfs and return true
            if (bfs(head, root)) {
                return true;
            }
            // else, continue to check left and right subtree
            return dfs(head, root.left) || dfs(head, root.right);
        }

        private boolean bfs(ListNode head, TreeNode root) {
            if (head.val != root.val) {
                return false;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            ListNode cur = head.next;
            while (!queue.isEmpty() && cur != null) {
                // do bfs level by level: linked list should be downward, single-branched
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null && node.left.val == cur.val) {
                        queue.add(node.left);
                    }
                    if (node.right != null && node.right.val == cur.val) {
                        queue.add(node.right);
                    }
                }
                // cur is one step faster than node
                if (!queue.isEmpty()) {
                    cur = cur.next;
                }
            }
            return cur == null;
        }
    }

    class Solution2 {
        // DFS + DFS
        public boolean isSubPath(ListNode head, TreeNode root) {
            return dfs(head, root);
        }

        private boolean dfs(ListNode head, TreeNode root) {
            if (root == null) {
                return false;
            }
            if (matches(head, root)) {
                return true;
            }
            return dfs(head, root.left) || dfs(head, root.right);
        }

        private boolean matches(ListNode head, TreeNode root) {
            if (head == null) {
                return true;
            }
            if (root == null || head.val != root.val) {
                return false;
            }
            // Coming to this line, we have head.val == root.val, continue to check the next level
            return matches(head.next, root.left) || matches(head.next, root.right);
        }
    }
}

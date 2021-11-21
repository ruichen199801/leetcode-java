package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator {

    // #173 https://leetcode.com/problems/binary-search-tree-iterator/
    // Tree, Binary Search Tree, Stack, Design

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class BSTIterator {

        // To achieve in-order: maintain a stack to store left children from root
        // When next() be called, pop one element and process its right child as new root

        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new ArrayDeque<>(); // Space = O(h)
            pushAll(root);
        }

        public int next() {
            TreeNode node = stack.pollFirst();  // Time = Amortized O(1)
            pushAll(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty(); // Time = O(1)
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                stack.offerFirst(node);
                node = node.left;
            }
        }

    }
}

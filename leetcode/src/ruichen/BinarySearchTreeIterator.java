package ruichen;

import ruichen.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator {
    // To achieve in-order: maintain a stack to store left children from root
    // When next() be called, pop one element and process its right child as new root
    class BSTIterator {
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

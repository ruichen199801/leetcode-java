package ruichen;

import ruichen.common.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    // naive idea: in-order traversal of BST produces an array sorted in ascending order.
    // improvement: we only need to compare two adjacent values in the sorted array, so we only
    //              need to store and compare prev and curr.
    // TC = O(n), SC = O(n)

    class Solution1 {
        // pass prev value as function parameter
        public int getMinimumDifference(TreeNode root) {
            int[] arr = { Integer.MAX_VALUE, Integer.MAX_VALUE }; // [prev, minDiff]
            inorder(root, arr);
            return arr[1];
        }

        private void inorder(TreeNode root, int[] arr) {
            if (root == null) {
                return;
            }
            inorder(root.left, arr);
            if (arr[0] != Integer.MAX_VALUE) {
                arr[1] = Math.min(arr[1], Math.abs(root.val - arr[0]));
            }
            arr[0] = root.val; // update prev value
            inorder(root.right, arr);
        }
    }

    class Solution2 {
        // pass prev node as return value (to play around "pass by value")

        // In Java, objects are passed by value, which means that when you assign a new value to prev, it doesn't affect the original variable
        // passed to the method. However, if we invoke dereference methods such as prev.val, prev.left, they will modify the original value.
        public int getMinimumDifference(TreeNode root) {
            int[] arr = { Integer.MAX_VALUE }; // [minDiff]
            inorder(root, null, arr);
            return arr[0];
        }

        private TreeNode inorder(TreeNode root, TreeNode prev, int[] arr) {
            if (root == null) {
                return prev;
            }
            prev = inorder(root.left, prev, arr);
            if (prev != null) {
                arr[0] = Math.min(arr[0], Math.abs(root.val - prev.val));
            }
            return inorder(root.right, root, arr); // update prev node
        }
    }
}

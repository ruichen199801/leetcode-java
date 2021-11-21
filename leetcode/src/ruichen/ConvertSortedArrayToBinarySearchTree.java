package ruichen;

public class ConvertSortedArrayToBinarySearchTree {

    // #108 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    // Tree, Binary Search Tree, Divide and Conquer
    // TC = O(n), SC = O(h)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(0, nums.length - 1, nums);
        }

        private TreeNode helper(int left, int right, int[] nums) {
            if (left > right) {
                return null;
            }
            int p = left + (right - left) / 2; // choose pivot
            TreeNode root = new TreeNode(nums[p]);
            root.left = helper(left, p - 1, nums);
            root.right = helper(p + 1, right, nums);
            return root;
        }
    }

}

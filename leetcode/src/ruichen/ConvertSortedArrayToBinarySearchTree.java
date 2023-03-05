package ruichen;

import ruichen.common.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    // TC = O(n), SC = O(h)
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

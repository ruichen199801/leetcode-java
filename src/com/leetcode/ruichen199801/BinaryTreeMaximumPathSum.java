package com.leetcode.ruichen199801;

public class BinaryTreeMaximumPathSum {
	
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
	    // #124 https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
	    // Tree, DFS, Recursion
	    // TC = O(n), SC = O(height)
	    public int maxPathSum(TreeNode root) {
	        // root is not null
	        int[] max = {Integer.MIN_VALUE};
	        helper(root, max);
	        return max[0];
	    }

	    private int helper(TreeNode root, int[] max) {
	        if (root == null) {
	            return 0;
	        }
	        int left = Math.max(0, helper(root.left, max));
	        int right = Math.max(0, helper(root.right, max));
	        max[0] = Math.max(max[0], left + right + root.val);
	        return Math.max(left, right) + root.val;
	    }
	}

}

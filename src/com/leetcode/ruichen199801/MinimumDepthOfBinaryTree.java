package com.leetcode.ruichen199801;

public class MinimumDepthOfBinaryTree {
	
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
	    // #111 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
	    // Tree, DFS, Recursion
	    // TC = O(n), SC = O(height)
	    public int minDepth(TreeNode root) {
	        // special case to handle: linked list
	        // [1, null, 2, null, 3, null, 4]
	        if (root == null) {
	            return 0;
	        } else if (root.left == null && root.right == null) {
	            return 1;
	        } else if (root.left == null) {
	            return minDepth(root.right) + 1;
	        } else if (root.right == null) {
	            return minDepth(root.left) + 1;
	        } else {
	            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	        }
	    }
	}

}

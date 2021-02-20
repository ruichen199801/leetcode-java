package com.leetcode.ruichen199801;

public class UnivaluedBinaryTree {
	
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
	    // #965 https://leetcode-cn.com/problems/univalued-binary-tree/
	    // Tree, DFS, Recursion
	    // TC = O(n), SC = O(height)
	    public boolean isUnivalTree(TreeNode root) {
	        if (root == null) {
	            return false;
	        }
	        int[] value = {root.val};
	        return helper(root, value);
	    }

	    private boolean helper(TreeNode root, int[] value) {
	        if (root == null) {
	            return true;
	        }
	        if (root.val != value[0]) {
	            return false;
	        } 
	        return helper(root.left, value) && helper(root.right, value);
	    }
	}

}

package com.leetcode.ruichen199801;

public class SameTree {
	
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
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        // #100 https://leetcode-cn.com/problems/same-tree/
	        // Tree, DFS, Recursion
	        // TC = O(n), SC = O(height)
	        if (p == null && q == null) {
	            return true;
	        } else if (p == null || q == null) {
	            return false;
	        } else if (p.val != q.val) {
	            return false;
	        }
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    }
	}

}

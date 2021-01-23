package com.leetcode.ruichen199801;

public class SearchInABinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	class Solution {

		// Tree
		// Iterative solution: TC = O(height), SC = O(1)

		public TreeNode searchBST(TreeNode root, int val) {
			while (root != null && root.val != val) {
				if (root.val > val) {
					root = root.left;
				} else {
					root = root.right;
				}
			}
			return root;
		}
	}
}

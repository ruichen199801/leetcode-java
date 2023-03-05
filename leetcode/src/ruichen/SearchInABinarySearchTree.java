package ruichen;

import ruichen.common.TreeNode;

public class SearchInABinarySearchTree {
	class Solution1 {
		// Recursive: TC = O(height), SC = O(height)
		public TreeNode searchBST(TreeNode root, int val) {
			if (root == null || root.val == val) {
				return root;
			}
			return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
		}
	}

	class Solution2 {
		// Iterative: TC = O(height), SC = O(1)
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

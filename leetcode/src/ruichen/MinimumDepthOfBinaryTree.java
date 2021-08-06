package ruichen;

public class MinimumDepthOfBinaryTree {

	// #111 https://leetcode.com/problems/minimum-depth-of-binary-tree/
	// Tree, Depth-first Search, Recursion
	// TC = O(n), SC = O(height)
	
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
		public int minDepth(TreeNode root) {

			// skip Math.min comparison when node is null to handle the case below:
			//  3
			//   \
			//    4
			//     \
			//      5
			//       \
			//        6

			if (root == null) {
				return 0;
			}
			if (root.left == null) {
				return minDepth(root.right) + 1;
			}
			if (root.right == null) {
				return minDepth(root.left) + 1;
			}
			return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		}
	}
}

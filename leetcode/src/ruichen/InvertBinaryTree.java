package ruichen;

public class InvertBinaryTree {
	
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

	    // #226 https://leetcode.com/problems/invert-binary-tree/
	    // Tree, Recursion
	    // TC = O(n), SC = O(height)

	    public TreeNode invertTree(TreeNode root) {

	        //    root
	        //    /  \
	        // -----------
	        // left right (already recursively reversed) 
	        // what's left to do? root.left = right, root.right = left

	        if (root == null) {
	            return null;
	        }
	        TreeNode left = invertTree(root.left);
	        TreeNode right = invertTree(root.right);
	        root.left = right;
	        root.right = left;
	        return root;
	    }
	}

}

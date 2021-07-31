package ruichen;

public class SymmetricTree {
	
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
	    // #101 https://leetcode-cn.com/problems/symmetric-tree/
	    // Tree, DFS, Recursion
	    // TC = O(n), SC = O(height)
	    public boolean isSymmetric(TreeNode root) {
	        if (root == null) {
	            return true;
	        } 
	        return isSymmetric(root.left, root.right);
	    }

	    private boolean isSymmetric(TreeNode left, TreeNode right) {
	        if (left == null && right == null) {
	            return true;
	        } else if (left == null || right == null) {
	            return false;
	        } else if (left.val != right.val) {
	            return false;
	        }
	        return isSymmetric(left.left, right.right) &&
	               isSymmetric(left.right, right.left);
	    }
	}

}

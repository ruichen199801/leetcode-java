package ruichen;

public class BalancedBinaryTree {
	
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
	
	class Solution1 {
	    // #110 https://leetcode-cn.com/problems/balanced-binary-tree/
	    // Tree, DFS, Recursion
	    // TC = O(nlog n), SC = O(height)
	    public boolean isBalanced(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        int left = getHeight(root.left);
	        int right = getHeight(root.right);
	        if (Math.abs(left - right) > 1) {
	            return false;
	        }
	        return isBalanced(root.left) && isBalanced(root.right);
	    }

	    private int getHeight(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	    }
	}
	
	class Solution2 {
	    // Better: TC = O(n), SC = O(height)
	    public boolean isBalanced(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        return height(root) != -1;
	    }

	    private int height(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        int left = height(root.left);
	        if (left == -1) {
	            return -1;
	        }
	        int right = height(root.right);
	        if (right == -1) {
	            return -1;
	        }
	        if (Math.abs(left - right) > 1) {
	            return -1;
	        }
	        return Math.max(left, right) + 1;
	    }
	}

}

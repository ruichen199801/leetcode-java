package ruichen;

public class SumOfLeftLeaves {
	
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
	    // #404 https://leetcode-cn.com/problems/sum-of-left-leaves/
	    // Tree, DFS, Recursion
	    // TC = O(n), SC = O(height), O(n) worst case
	    public int sumOfLeftLeaves(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        int[] sum = {0};
	        helper(root, sum);
	        return sum[0];
	    }

	    private void helper(TreeNode root, int[] sum) {
	        if (root == null) {
	            return;
	        }
	        if (root.left != null && root.left.left == null && root.left.right == null) {
	            sum[0] += root.left.val;
	        }
	        helper(root.left, sum);
	        helper(root.right, sum);
	    }
	}

}

package ruichen;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
	
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

	    // #872 https://leetcode.com/problems/leaf-similar-trees/
	    // Tree, DFS, Recursion
	    // TC = O(N1 + N2), SC = O(H1 + H2) (stack), O(L1 + L2) (heap)
		// N: # of nodes, H: height of binary tree, L: # of leaves

	    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	        // root1 and root2 are not null
	        List<Integer> l1 = new ArrayList<>();     
	        List<Integer> l2 = new ArrayList<>();   
	        helper(root1, l1);
	        helper(root2, l2);
	        return l1.equals(l2); 
	    }
	    
	    private void helper(TreeNode root, List<Integer> result) {
	        // below leaf
	        if (root == null) {
	            return;
	        }
	        // leaf
	        if (root.left == null && root.right == null) {
	            result.add(root.val);
	        }
	        helper(root.left, result);
	        helper(root.right, result);
	    }
	}

}

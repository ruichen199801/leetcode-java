package ruichen;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    // #437 https://leetcode.com/problems/path-sum-iii/
    // Tree, Depth-first Search, Prefix Sum
    // TC = O(n), SC = O(n) (hash map)

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

        private int count = 0;
        private int k;
        private Map<Integer, Integer> map = new HashMap<>(); // <prefixSum, frequency>

        public int pathSum(TreeNode root, int targetSum) {
            k = targetSum;
            helper(root, 0);
            return count;
        }

        // Prefix sum
        private void helper(TreeNode root, int curSum) {
            if (root == null) {
                return;
            }
            // what is left to do for the current root node? -> update current node value to curSum and check 2 cases
            curSum += root.val;
            // case 1:
            if (curSum == k) {
                count++;
            }
            // case 2:
            count += map.getOrDefault(curSum - k, 0);
            // update curSum into hashmap
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
            // recursively check left and right subtrees
            helper(root.left, curSum);
            helper(root.right, curSum);
            // remove after dfs to guarantee it's a "path" (not to blend the parallel subtrees)
            map.put(curSum, map.get(curSum) - 1);
        }
    }
}

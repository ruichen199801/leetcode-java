package ruichen;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    // #337 https://leetcode.com/problems/house-robber-iii/
    // Tree, Depth-first Search, Dynamic Programming

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution1 {
        // Method 1: Recursion + Memoization: TC = O(n),  SC = O(n)
        // Memo: we have overlapping sub-problems, rob(root) does not distinguish b/t rob / not rob, have to re-compare each time
        public int rob(TreeNode root) {
            Map<TreeNode, Integer> memo = new HashMap<>();
            return rob(root, memo);
        }

        private int rob(TreeNode root, Map<TreeNode, Integer> memo) {
            if (root == null) {
                return 0;
            }
            if (memo.containsKey(root)) {
                return memo.get(root);
            }
            // rob
            int rob = root.val;
            if (root.left != null) {
                rob = rob + rob(root.left.left, memo) + rob(root.left.right, memo);
            }
            if (root.right != null) {
                rob = rob + rob(root.right.left, memo) + rob(root.right.right, memo);
            }
            // not rob
            int notRob = rob(root.left, memo) + rob(root.right, memo);
            int res = Math.max(rob, notRob);
            memo.put(root, res);
            return res;
        }
    }

    class Solution2 {
        // Method 2: Dynamic Programming (better): TC = O(n),  SC = O(n)
        public int rob(TreeNode root) {
            // res[0]: max profit for rob
            // res[1]: max profit for not rob
            // record both states of each node during recursion
            int[] res = helper(root);
            return Math.max(res[0], res[1]);
        }

        private int[] helper(TreeNode root) {
            if (root == null) {
                return new int[2]; // [0, 0]
            }
            int[] leftRes = helper(root.left);
            int[] rightRes = helper(root.right);
            // rob current node: must not rob next node
            int rob = root.val + leftRes[1] + rightRes[1];
            // not rob current node: can rob or not rob next node
            int notRob = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
            return new int[] {rob, notRob};
        }
    }
}

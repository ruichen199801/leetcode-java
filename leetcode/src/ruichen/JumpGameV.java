package ruichen;

public class JumpGameV {

    // #1340 https://leetcode.com/problems/jump-game-v/
    // Array, Depth-first Search

    class Solution {
        // DFS + Memo: TC = O(n * 2d) = O(nd), SC = O(n + n) = O(n)
        public int maxJumps(int[] arr, int d) {
            int max = 0;
            int[] memo = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, dfs(arr, d, i, memo));
            }
            return max;
        }

        private int dfs(int[] arr, int d, int i, int[] memo) {
            if (memo[i] != 0) {
                return memo[i];
            }
            int res = 0;
            // set up valid bounds
            int left = Math.max(0, i - d), right = Math.min(arr.length - 1, i + d);
            // check left
            for (int j = i - 1; j >= left && arr[j] < arr[i]; j--) {
                res = Math.max(res, dfs(arr, d, j, memo));
            }
            // check right
            for (int j = i + 1; j <= right && arr[j] < arr[i]; j++) {
                res = Math.max(res, dfs(arr, d, j, memo));
            }
            // mark as visited
            memo[i] = res + 1; // +1: itself
            return memo[i];
        }
    }
}

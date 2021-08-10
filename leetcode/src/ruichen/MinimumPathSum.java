package ruichen;

public class MinimumPathSum {

    // #64 https://leetcode.com/problems/minimum-path-sum/
    // Dynamic Programming

    class Solution {

        public int minPathSum(int[][] grid) {

            // grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
            // TC = O(m * n), SC = O(1)
            // We modified input in place to save memory (clarify with interviewer whether we are allowed to do this)

            if (grid == null || grid.length == 0) {
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) {
                        grid[i][j] = grid[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        grid[i][j] = grid[i - 1][j] + grid[i][j];
                    } else {
                        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return grid[m - 1][n - 1];
        }
    }
}

package ruichen;

public class MinimumPathSum {
    // Similar to #62
    class Solution1 {
        // grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]
        // TC = O(m * n), SC = O(1)
        // We modified input in place to save memory (clarify with interviewer whether we are allowed to do this)
        public int minPathSum(int[][] grid) {
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

    class Solution2 {
        // DP: 2D -> 1D
        public int minPathSum(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] dp = new int[n];
            for (int i = 0; i < m; i++) { // row
                for (int j = 0; j < n; j++) { // col
                    if (i == 0 && j == 0) {
                        dp[j] = grid[i][j]; // (0, 0)
                    } else if (i == 0) {
                        dp[j] = grid[i][j] + dp[j - 1]; // first row
                    } else if (j == 0) {
                        dp[j] = grid[i][j] + dp[j]; // first col
                    } else {
                        dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]); // dp[j - 1]: current run on the left side, dp[j]: last run on the upper side
                    }
                }
            }
            return dp[n - 1];
        }
    }
}

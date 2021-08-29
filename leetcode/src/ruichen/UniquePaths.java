package ruichen;

public class UniquePaths {

    // #62 https://leetcode.com/problems/unique-paths/
    // Dynamic Programming
    // TC = O(m * n): we must touch every element a single time in our grid
    // SC = O(m * n): we must initialize a 2D grid containing m * n elements

    class Solution {
        public int uniquePaths(int m, int n) {
            // (i, j) = dp[i - 1][j] + dp[i][j - 1], look to the top and left
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}

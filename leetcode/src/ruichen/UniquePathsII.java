package ruichen;

public class UniquePathsII {
    class Solution1 {
        // TC = O(m * n): we must touch every element a single time in our grid
        // SC = O(m * n): we must initialize a 2D grid containing m * n elements
        // If we are allowed to modify obstacleGrid in-place, SC should be O(1)

        // case 1: first row
        // (i, j) = dp[i][j - 1] or 0 (not 1, cuz left ones may be obstacle)

        // case 2: first column
        // (i, j) = dp[i - 1][j] or 0 (not 1, cuz upper ones may be obstacle)

        // case 3: general case
        // if (i, j) not obstacle: (i, j) = dp[i - 1][j] + dp[i][j - 1]
        // else: (i, j) = 0
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                    } else if (i == 0) {
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j];
                    } else {
                        dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    class Solution2 {
        // DP: 2D -> 1P, SC = O(n)
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[] dp = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
                    } else if (j == 0) {
                        dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0]; // [[1], [0]], expected 0 instead of 1
                    } else {
                        dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1] + dp[j];
                    }
                }
            }
            return dp[n - 1];
        }
    }
}

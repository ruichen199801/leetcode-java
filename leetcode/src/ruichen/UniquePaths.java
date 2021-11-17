package ruichen;

import java.util.Arrays;

public class UniquePaths {

    // #62 https://leetcode.com/problems/unique-paths/
    // Dynamic Programming
    // 2D -> 2 rows -> 1 row -> O(1) flow: https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP

    class Solution {
        public int uniquePaths1(int m, int n) {
            // 2D DP:
            // TC = O(m * n): we must touch every element a single time in our grid
            // SC = O(m * n): we must initialize a 2D grid containing m * n elements
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

        public int uniquePaths2(int m, int n) {
            // 2D to 1D intuition: O(3 * n) (we only care about and are only updating current row and previous row)
            int[] preRow = new int[n];
            int[] initRow = new int[n];
            initRow[0] = 1;
            Arrays.fill(preRow, 1); // row 0
            int[] curRow = initRow; // initialize curRow as a "clean" row and build it from scratch each time
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    curRow[j] = curRow[j - 1] + preRow[j];
                }
                preRow = curRow;
                curRow = initRow;
            }
            return preRow[n - 1];
        }

        public int uniquePaths3(int m, int n) {
            // O(2 * n)
            int[] preRow = new int[n];
            int[] curRow = new int[n];
            Arrays.fill(preRow, 1);
            Arrays.fill(curRow, 1);
            // curRow doesn't have to be that clean, it can be a mess, we eventually will overwrite it anyways
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    curRow[j] = curRow[j - 1] + preRow[j];
                }
                int[] temp = preRow;
                preRow = curRow;
                curRow = temp;
            }
            return preRow[n - 1];
        }

        public int uniquePaths4(int m, int n) {
            // O(n): can further reduced to 1 row b/c pre[j] is just cur[j] before the update
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
}

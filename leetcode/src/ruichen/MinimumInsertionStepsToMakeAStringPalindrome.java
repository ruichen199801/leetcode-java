package ruichen;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    // DP: TC = O(n^2), SC = O(n^2)
    class Solution {
        public int minInsertions(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[][] dp = new int[n][n];
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i <= n - len; i++) {
                    int j = i + len - 1;
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}

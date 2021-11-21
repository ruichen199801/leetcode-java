package ruichen;

public class EditDistance {

    // #72 https://leetcode.com/problems/edit-distance/
    // String, Dynamic Programming
    // TC = O(m * n), SC = O(m * n)

    class Solution {
        public int minDistance(String word1, String word2) {
            //    '' f r o g
            // '' 0  1 2 3 4
            // d  1    b
            // o  2  a x
            // g  3

            // x: do -> fr
            // a: do -> f: +r
            // b: d -> fr: -o

            // fill in first row and first col first
            // state transfer function:
            // if c1 != c2: min(insert, delete, replace) + 1
            //              min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
            // if c1 == c2: dp[i-1][j-1]
            int len1 = word1.length(), len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    } else if (j == 0) {
                        dp[i][j] = i;
                    } else {
                        // watch out for array index out of bound exception!
                        char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                        if (c1 == c2) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                        }
                    }
                }
            }
            return dp[len1][len2];
        }
    }
}

package ruichen;

public class RegularExpressionMatching {

    // #10 https://leetcode.com/problems/regular-expression-matching/
    // String, Dynamic Programming
    // TC = O(n * m), SC = O(n * m)

    class Solution {
        public boolean isMatch(String s, String p) {

        /* Compare two strings: 2D DP (edit distance variation)
        1. If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
        2. If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
        3. If p.charAt(j) == '*':
          3.1 if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]
              in this case, a* only counts as empty
          3.2 if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                 dp[i][j] = dp[i-1][j]  in this case, a* counts as multiple a
              or dp[i][j] = dp[i][j-1]  in this case, a* counts as single a
              or dp[i][j] = dp[i][j-2]  in this case, a* counts as empty

              s = "aab", p = "c*a*b"
                 '' c * a * b
              '' T  F T F T F (c* = empty)
              a           m
              a       k n x
              b
         */

            int len1 = s.length(), len2 = p.length();
            boolean[][] dp = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {

                    // only p may contain regex
                    // charAt's index is one offset less than dp array's index
                    // TFTFTF
                    // now we are looking at i, j in dp array
                    // which also means i-1, j-1 in s, p respectively
                    // c  *  a  *  b
                    //      j-1 j

                    if (i == 0) {
                        if (p.charAt(j) == '*' && dp[i][j - 1]) {
                            dp[i][j + 1] = true;
                        }
                    }
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                        }
                    }
                }
            }
            return dp[len1][len2];
        }
    }

}

package ruichen;

public class DecodeWays {
    // TC = O(n), SC = O(n)
    class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;
            for (int i = 2; i <= n; i++) {
                int oneDigit = Integer.parseInt(s.substring(i - 1, i));
                int twoDigits = Integer.parseInt(s.substring(i - 2, i));
                if (oneDigit >= 1 && oneDigit <= 9) {
                    dp[i] += dp[i - 1];
                }
                if (twoDigits >= 10 && twoDigits <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
}

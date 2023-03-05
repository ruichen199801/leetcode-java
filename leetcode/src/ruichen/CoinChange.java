package ruichen;

import java.util.Arrays;

public class CoinChange {
    // dp[i] = min{dp[i - coinVal] + 1)}, coinVal is in [coins]
    // TC = O(nk), SC = O(n), n = amount, k = length of coins
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1]; // If we initialize with Integer.MAX_VALUE, +1 will cause overflow
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int coinVal : coins) {
                    if (coinVal <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coinVal] + 1);
                    }
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}

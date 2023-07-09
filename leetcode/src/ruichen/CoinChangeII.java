package ruichen;

public class CoinChangeII {
    // CoinChangeI:  dp[i] - min # of coins to make amount i
    //               for i = 1 to amount,
    //                  for coin in coins,
    //                      dp[i] = min{dp[i - coin] + 1}, coin <= i

    // CoinChangeII: dp[i] - # of coin combinations to make amount i
    //               for coin in coins,
    //                  for i = 1 to amount,
    //                      dp[i] += dp[i - coin], coin <= i

    // Iterating over coins first ensures that each coin is used only once in each combination.
    // If we iterate from i to amount in the outer loop, consider the following example:
    // amount = 5, coins = [2, 3]
    // dp[2] = 1 (2)
    // dp[3] = 1 (3)
    // dp[5] = dp[2] + dp[3] = 2 ([2,3], [3,2]), but it actually should be counted only once ([2,3]).

    // TC = O(kn), SC = O(n), where k: coin values, n: amount
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1; // there is one way to make an amount of 0 (by using no coins)

            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }

            return dp[amount];
        }
    }
}

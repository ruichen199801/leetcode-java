package ruichen;

public class BestTimeToBuyAndSellStockII {

    // #122 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    // TC = O(n), SC = O(1)

    class Solution {
        public int maxProfit(int[] prices) {
            // DP: Sum up all the positive differences
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit += Math.max(0, prices[i] - prices[i - 1]);
            }
            return maxProfit;
        }
    }
}

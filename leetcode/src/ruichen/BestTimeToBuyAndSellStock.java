package ruichen;

public class BestTimeToBuyAndSellStock {

    // #121 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    // TC = O(n), SC = O(1)

    class Solution1 {
        public int maxProfit(int[] prices) {
            // DP
            int minPrice = Integer.MAX_VALUE, maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            return maxProfit;
        }
    }

    class Solution2 {
        public int maxProfit(int[] prices) {
            // Kadane's Algorithm
            // Calculate difference, find the maximum subarray of price differneces == profit
            // If the difference falls below 0, reset it to zero
            int curProfit = 0, maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int diff = prices[i] - prices[i - 1];
                curProfit = Math.max(0, curProfit + diff);
                maxProfit = Math.max(maxProfit, curProfit);
            }
            return maxProfit;
        }
    }
}

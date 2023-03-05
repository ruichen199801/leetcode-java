package ruichen;

public class BestTimeToBuyAndSellStock {
    class Solution1 {
        // DP: TC = O(n), SC = O(1)
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE, maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            return maxProfit;
        }
    }

    class Solution2 {
        // Kadane's Algorithm: : TC = O(n), SC = O(1)
        // Calculate difference, find the maximum subarray of price differences == profit
        // If the difference falls below 0, reset it to zero
        public int maxProfit(int[] prices) {
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

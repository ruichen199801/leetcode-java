package ruichen;

public class CombinationSumIV {
    // Coin Change DP: TC = O(nt), SC = O(t), where n: nums length, t: target
    // Recursive equation: dp[i] = sum{ dp[i - num] }, for num in nums
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] <= i) {
                        dp[i] += dp[i - nums[j]];
                    }
                }
            }
            return dp[target];
        }
    }
}

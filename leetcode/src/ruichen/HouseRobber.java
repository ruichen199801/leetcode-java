package ruichen;

public class HouseRobber {
    class Solution1 {
        // DP: TC = O(n), SC = O(n)

        // dp[i]: max profit when we are looking at i-th house
        // state: current house location, choice: steal or not steal

        // case 1: steal i-1 th house: must not steal i-th house
        //         dp[i] = dp[i - 1]
        // case 2: not steal i-1 th house: can steal or not steal i-th house
        //         dp[i] = max(steal, not steal) = max(value[i] + dp[i - 2], dp[i - 1])
        // state transfer function: dp[i] = max(value[i] + dp[i - 2], dp[i - 1])
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
            }
            return dp[nums.length];
        }
    }

    class Solution2 {
        // Optimized DP: TC = O(n), SC = O(n)
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int stealLastLast = 0;    // dp[i - 2]
            int stealLast = nums[0];  // dp[i - 1]
            for (int i = 2; i <= nums.length; i++) {
                int stealCur = Math.max(nums[i - 1] + stealLastLast, stealLast); // dp[i]
                stealLastLast = stealLast;
                stealLast = stealCur;
            }
            return stealLast;
        }
    }
}

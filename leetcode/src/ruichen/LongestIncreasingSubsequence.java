package ruichen;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // #300 https://leetcode.com/problems/longest-increasing-subsequence/
    // Dynamic Programming
    // TC = O(n^2), SC = O(n)

    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }
            int maxLen = 1;

            // dp[i]: LIS ending at exactly index i, not the final answer!
            // dp[i] = max{dp[j] + 1}, where 0 ≤ j < i and nums[j] < nums[i]
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        maxLen = Math.max(maxLen, dp[i]);
                    }
                }
            }
            return maxLen;
        }
    }
}

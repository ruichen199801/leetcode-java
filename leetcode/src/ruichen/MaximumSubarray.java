package ruichen;

public class MaximumSubarray {

	// #53 https://leetcode.com/problems/maximum-subarray/
	// Dynamic Programming
	// TC = O(n), SC = O(1)

	class Solution {
		// Kadane's Algorithm
		public int maxSubArray(int[] nums) {
			int result = nums[0];
			int cur = nums[0];
			for (int i = 1; i < nums.length; i++) {
				cur = Math.max(nums[i], nums[i] + cur);
				result = Math.max(result, cur);
			}
			return result;
		}
	}

    // dp[i]: the largest sum of subarray ending at index i
    // dp[i] = array[i]               if dp[i - 1] <= 0
    //       = dp[i - 1] + array[i]   if dp[i - 1] > 0
	// decide whether "worth" adding into the result or not: > 0
    // use a result and cur variable instead of int[] dp to save memory

}

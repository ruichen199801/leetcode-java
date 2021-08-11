package ruichen;

public class MaximumSubarray {

	// #53 https://leetcode.com/problems/maximum-subarray/
	// Dynamic Programming
	// TC = O(n), SC = O(1)

	class Solution {

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

    //       [-2  1 -3  4 -1  2  1 -5  4]
    // index   0  1  2  3  4  5  6  7  8
    // cur    -2  1 -2  4  3  5  6  1  5
    // result -2  1  1  4  4  5  6  6  6

}

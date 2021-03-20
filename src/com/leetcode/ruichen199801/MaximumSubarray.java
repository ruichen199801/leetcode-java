package com.leetcode.ruichen199801;

public class MaximumSubarray {
	
	class Solution {
	    public int maxSubArray(int[] nums) {
	        // #53 https://leetcode-cn.com/problems/maximum-subarray/
	        // DP, TC = O(n), SC = O(1)
	        // f(x) = max {f(x - 1) + nums[i], nums[i]}
	        int res = nums[0], cur = 0;
	        for (int i = 0; i < nums.length; i++) {
	            cur = Math.max(nums[i], cur + nums[i]);
	            res = Math.max(res, cur);
	        }
	        return res;
	    }
	}

}

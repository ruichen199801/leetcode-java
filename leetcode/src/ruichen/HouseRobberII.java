package ruichen;

import java.util.Arrays;

public class HouseRobberII {
    // TC = O(n), SC = O(n)
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) { // avoid NPE
                return nums[0];
            }
            // rob house 1 - n-1 || house 2 - n
            int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length); // [i, j)
            int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
            return Math.max(dp(nums1), dp(nums2));
        }

        private int dp(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
            }
            return dp[nums.length];
        }
    }
}

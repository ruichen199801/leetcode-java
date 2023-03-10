package ruichen;

public class MaxConsecutiveOnes {
    // DP: TC = O(n), SC = O(1)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int n = nums.length;
            int max = nums[0] == 1 ? 1 : 0;
            int curMax = max;
            for (int i = 1; i < n; i++) {
                if (nums[i] == 1) {
                    curMax++;
                    max = Math.max(max, curMax);
                } else {
                    curMax = 0;
                }
            }
            return max;
        }
    }
}

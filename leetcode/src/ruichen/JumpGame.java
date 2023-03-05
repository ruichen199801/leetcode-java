package ruichen;

public class JumpGame {
    // TC = O(n), SC = O(1)
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int end = len - 1;
            for (int i = len - 2; i >= 0; i--) {
                if (i + nums[i] >= end) {
                    end = i;
                }
            }
            return end == 0; // can reach end from index 0
        }
    }
}

package com.leetcode.ruichen199801;

public class JumpGameII {

    class Solution {

        // #45 https://leetcode-cn.com/problems/jump-game-ii/
        // Dynamic Programming
        // TC = O(n), SC = O(1)

        public int jump(int[] nums) {
            //   i    0 1 2 3 4 5 6
            //       [2,3,1,2,4,2,3]
            // maxPos 2 4   5 8
            // end    2   4   8
            // step   1   2   3
            int end = 0;
            int maxPos = 0;
            int step = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxPos = Math.max(maxPos, nums[i] + i);
                if (i == end) {
                    end = maxPos;
                    step++;
                }
            }
            return step;
        }
    }
}

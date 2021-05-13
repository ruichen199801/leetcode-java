package com.leetcode.ruichen199801;

public class FirstMissingPositive {

    // #41 https://leetcode-cn.com/problems/first-missing-positive/
    // Array

    class Solution {
        // TC = O(n), SC = O(1)
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            // hash table in situ: mark with negative sign
            // positve integer: 1 - N -> index: 0 - N-1
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }
    }
}

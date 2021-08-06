package ruichen;

import java.util.Arrays;

public class TwoSumLessThanK {

    // #1099 https://leetcode.com/problems/two-sum-less-than-k/
    // Array, Two Pointers
    // Two Sum Problems: 1) Hash Table  2) Two Pointers

    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {

            // Two Pointers
            // Total complexity depends on sorting, two pointer only takes O(n) time and O(1) space

            Arrays.sort(nums);
            int sum = -1;
            int l = 0, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] < k) {
                    sum = Math.max(sum, nums[l] + nums[r]);
                    l++;
                } else {
                    r--;
                }
            }
            return sum;
        }
    }
}

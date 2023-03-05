package ruichen;

import java.util.Arrays;

public class TwoSumLessThanK {
    // Two Pointers
    // Total complexity depends on sorting, two pointer only takes O(n) time and O(1) space
    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
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

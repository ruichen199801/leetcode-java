package com.leetcode.ruichen199801;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    // #448 https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
    // Array

    class Solution {
        // Same as #41 First Missing Positive
        // Hash map in situ: TC = O(n), SC = O(1)
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length; // 1 <= nums[i] <= n
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}

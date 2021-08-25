package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    // #18 https://leetcode.com/problems/4sum/
    // Array, Two Pointers
    // TC = O(n^3), SC = O(log n)

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j - 1] == nums[j]) {
                        continue;
                    }
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            l++;
                            while (l < nums.length && nums[l - 1] == nums[l]) {
                                l++;
                            }
                        } else if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
            return result;
        }
    }
}

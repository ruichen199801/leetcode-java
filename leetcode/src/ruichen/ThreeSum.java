package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // #15 https://leetcode.com/problems/3sum/
    // Array, Two Pointers

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            // Two Pointers (Recommended)
            // Wrap a for-loop around TwoSum (de-dup can be a little tricky)
            // TC = O(n log n) (sorting) + O(n^2) (n * TwoSum) = O(n^2)
            // SC = O(log n), depends on implementation of sorting
            // For the purpose of complexity analysis, we ignore the memory required for the output

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue; // it's easier to deal with duplicates if the array is sorted: repeated values are next to each other and easy to skip.
                }
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == 0) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        while (l < r && nums[l - 1] == nums[l]) {
                            l++;
                        }
                    } else if (nums[i] + nums[l] + nums[r] < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return result;
        }
    }
}

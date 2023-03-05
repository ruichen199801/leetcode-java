package ruichen;

import java.util.Arrays;

public class ThreeSumClosest {
    // Two Pointers: TC = O(log n + n^2) = O(n^2), SC = O(log n) (sorting)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            // we can use sum here, but to initialize it with Integer.MAX_VALUE or Integer.MIN_VALUE could cause ambiguity or worse, integer overflow
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    // corner case
                    if (sum == target) {
                        return sum;
                    }
                    // update diff when necessary
                    if (Math.abs(sum - target) < Math.abs(diff)) {
                        diff = sum - target; // retain sign
                    }
                    // move pointers
                    if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return diff + target;
        }
    }
}

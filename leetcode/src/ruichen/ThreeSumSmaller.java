package ruichen;

import java.util.Arrays;

public class ThreeSumSmaller {
    // [1, 2, 3, 5, 8]
    //  l        r
    // if (nums[i] + nums[l] + nums[r] < target):
    // (1,2) (1,3) (1,5) all satisfies, so count += r - l, l++
    // else: r--

    // TC = O(n^2), SC = O(log n)
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int count = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] < target) {
                        count += r - l;
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return count;
        }
    }
}

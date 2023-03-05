package ruichen;

public class MaximumProductSubarray {
    // If there's no zero in the array, then the subarray with maximum product must start with the first element or end with the last element.
    // And therefore, the maximum product must be some prefix product or suffix product. (easy to prove)

    // nums = [2, 3, -2, 4]
    // prefix  2  6 -12 -48
    // suffix  4 -8 -24 -48
    // cur     4  6 -12 -48
    // res     4  6  6   6

    // nums =  [-2,0,-1]
    // prefix   -2 0 -1
    // suffix   -1 0 -2
    // cur      -1 0 -1
    // res      -1 0  0

    // TC = O(n), SC = O(1)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int cur = nums[0], res = nums[0];
            int prefix = 0, suffix = 0;
            for (int i = 0; i < n; i++) {
                prefix = prefix == 0 ? 1 : prefix;
                prefix *= nums[i];
                suffix = suffix == 0 ? 1 : suffix;
                suffix *= nums[n - i - 1];
                cur = Math.max(prefix, suffix);
                res = Math.max(res, cur);
            }
            return res;
        }
    }
}

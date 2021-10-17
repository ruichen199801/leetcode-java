package ruichen;

public class ProductOfArrayExceptSelf {

    // #238 https://leetcode.com/problems/product-of-array-except-self/
    // Array, Prefix Sum

    class Solution1 {
        // Method 1: 3 arrays + 3 pass, TC = O(n), SC = O(n)
        public int[] productExceptSelf(int[] nums) {
            // nums    1  2  3 4
            // prefix  1  1  2 6
            // suffix  24 12 4 1
            // result  24 12 8 6
            int len = nums.length;
            int[] left = new int[len]; // prefix product
            int[] right = new int[len]; // suffix product
            int[] result = new int[len]; // result = prefix product * suffix product

            left[0] = 1;
            for (int i = 1; i < len; i++) {
                left[i] = left[i - 1] * nums[i - 1];
            }

            right[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                right[i] = right[i + 1] * nums[i + 1];
            }

            for (int i = 0; i < len; i++) {
                result[i] = left[i] * right[i];
            }
            return result;
        }
    }

    class Solution2 {
        // Method 2: One pass, TC = O(n), SC = O(1) (result array not counted)
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] result = new int[len];
            result[0] = 1;
            for (int i = 1; i < len; i++) {
                result[i] = result[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = len - 2; i >= 0; i--) {
                right *= nums[i + 1];
                result[i] *= right;
            }
            return result;
        }
    }

}

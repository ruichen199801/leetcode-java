package ruichen;

public class SignOfTheProductOfAnArray {

    // #1822 https://leetcode.com/problems/sign-of-the-product-of-an-array/
    // Array, Math
    // TC = O(n), SC = O(1)

    class Solution {
        public int arraySign(int[] nums) {
            // we only need to determine sign instead of computing actual value
            int product = 1;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                } else if (num < 0) {
                    product = product * (-1);
                }
            }
            return product;
        }
    }
}

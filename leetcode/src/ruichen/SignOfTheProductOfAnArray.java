package ruichen;

public class SignOfTheProductOfAnArray {
    // TC = O(n), SC = O(1)
    class Solution {
        public int arraySign(int[] nums) {
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

package ruichen;

public class PlusOne {

    // #66 https://leetcode.com/problems/plus-one/
    // Math
    // TC = O(n), SC = O(1) average, O(n) worst (99999 case)

    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            for (int i = len - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i]++;
                    return digits; // return immediately if carry is zero
                }
                digits[i] = 0;
            }
            // 9999 -> 10000: let digits point to a new memory address with default 0s, set the first element to 1
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        }
    }
}

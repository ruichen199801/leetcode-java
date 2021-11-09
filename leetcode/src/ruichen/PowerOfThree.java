package ruichen;

public class PowerOfThree {

    // #326 https://leetcode.com/problems/power-of-three/
    // Math
    // TC = O(log n), SC = O(1)

    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n < 1) {
                return false;
            }
            while (n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
    }
}

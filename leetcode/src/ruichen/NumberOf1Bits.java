package ruichen;

public class NumberOf1Bits {

    // #191 https://leetcode.com/problems/number-of-1-bits/
    // Bit Manipulation
    // TC = O(1), SC = O(1)

    public class Solution {
        public int hammingWeight(int n) {
            // bit tester: (x >> k) & 1 == 0
            int numOnes = 0;
            for (int i = 0; i < 32; i++) {
                numOnes += (n >> i) & 1;
            }
            return numOnes;
        }
    }
}

package ruichen;

public class NumberOf1Bits {
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

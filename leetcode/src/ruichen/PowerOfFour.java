package ruichen;

public class PowerOfFour {
    // 2^n but not 4^n: 0 0 1 0, 1 is at odd index
    // 4^n:             0 1 0 0, 1 is at even index
    // 1010 -> decimal: 10 -> 0x: A
    // int -> 32 bits -> 8 hex: 0x AAAAAAAA

    // TC = O(1), SC = O(1)
    class Solution {
        public boolean isPowerOfFour(int n) {
            return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
        }
    }
}

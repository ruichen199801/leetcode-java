package ruichen;

public class FlipStringToMonotoneIncreasing {
    // Skip 0's until we encounter the first 1.
    // Keep track of number of 1's in onesCount (Prefix).
    // Any 0 that comes after we encounter 1 can be a potential candidate for flip. Keep track of it in flipCount.
    // If flipCount exceeds oneCount - (Prefix 1's flipped to 0's)
    // a. Then we are trying to flip more 0's (suffix) than number of 1's (prefix) we have.
    // b. It's better to flip the 1's instead.

    // TC = O(n), SC = O(1)
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int flipCount = 0;
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '0') {
                    if (oneCount == 0) {
                        continue;
                    } else {
                        flipCount++;
                    }
                } else {
                    oneCount++;
                }
                flipCount = Math.min(flipCount, oneCount);
            }
            return flipCount;
        }
    }
}

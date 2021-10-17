package ruichen;

public class MaximumValueAfterInsertion {

    // #1881 https://leetcode.com/problems/maximum-value-after-insertion/
    // String
    // TC = O(n) (for loop), SC = O(n) (substring)

    class Solution {
        public String maxValue(String n, int x) {

            // Case 1: Number is positive
            // Find maximum: if s[i] < x it's optimal that x is put before s[i].
            // Case 2: Number is negative
            // Find minimum: if s[i] > x it's optimal that x is put before s[i].
            // If all digits are the same as x: doesn't matter, insert at last digit after the loop is finished

            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(0) != '-' && n.charAt(i) - '0' < x ||
                        n.charAt(0) == '-' && n.charAt(i) - '0' > x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            }
            return n + x; // string concatenation: int treated as str
        }
    }
}

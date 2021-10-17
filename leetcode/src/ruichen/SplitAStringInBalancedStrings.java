package ruichen;

public class SplitAStringInBalancedStrings {

    // #1221 https://leetcode.com/problems/split-a-string-in-balanced-strings/
    // String, Counting
    // TC = O(n), SC = O(1)

    class Solution {
        public int balancedStringSplit(String s) {
            int res = 0, count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += s.charAt(i) == 'L' ? 1 : -1;
                if (count == 0) {
                    res++;
                }
            }
            return res;
        }
    }
}

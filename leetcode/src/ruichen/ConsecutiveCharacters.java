package ruichen;

public class ConsecutiveCharacters {

    // #1446 https://leetcode.com/problems/consecutive-characters/
    // String, Counting
    // TC = O(n), SC = O(1)

    class Solution {
        public int maxPower(String s) {
            // -> count the length of the longest consecutive substring
            // 1 <= s.length <= 500
            int res = 1, cur = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    cur++;
                    res = Math.max(res, cur);
                } else {
                    cur = 1;
                }
            }
            return res;
        }
    }
}

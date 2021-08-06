package ruichen;

public class MaximumNestingDepthOfTheParentheses {

    // #1614 https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
    // String
    // TC = O(n), SC = O(1)

    class Solution {
        public int maxDepth(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int max = 0, curr = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    curr++;
                    max = Math.max(max, curr);
                }
                if (ch == ')') {
                    curr--;
                }
            }
            return max;
        }
    }
}

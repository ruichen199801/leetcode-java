package ruichen;

public class LongestValidParentheses {
    // Two Passes: TC = O(n), SC = O(1)
    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int left = 0, right = 0;
            int maxLen = 0;
            // From left to right: cannot cover (((()...
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxLen = Math.max(maxLen, 2 * right);
                } else if (left < right) { // ())...
                    left = right = 0;
                }
            }

            // From right to left: cannot cover ...())))
            left = right = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    maxLen = Math.max(maxLen, 2 * left);
                } else if (left > right) { // ...(()
                    left = right = 0;
                }
            }

            return maxLen;
        }
    }
}

package ruichen;

public class RotateString {
    // Other ideas: Jaccard similarity (A + A).contains(B); rolling hash
    // TC = O(n^2), SC = O(1)
    class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            for (int offset = 0; offset < s.length(); offset++) {
                if (rotateString(s, goal, offset)) {
                    return true;
                }
            }
            return false;
        }

        private boolean rotateString(String s, String goal, int offset) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt((i + offset) % goal.length())) {
                    return false;
                }
            }
            return true;
        }
    }
}

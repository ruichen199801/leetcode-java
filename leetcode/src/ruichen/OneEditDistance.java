package ruichen;

public class OneEditDistance {

    // #161 https://leetcode.com/problems/one-edit-distance/
    // String, Two Pointers
    // TC = O(n), SC = O(1)

    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            int n = s.length(), m = t.length();
            if (n - m == 1) {
                return isOneDeleteDistance(s, t);
            } else if (m - n == 1) {
                return isOneDeleteDistance(t, s);
            } else if (m == n) {
                return isOneChangeDistance(s, t);
            }
            return false;
        }

        private boolean isOneDeleteDistance(String s, String t) {
            boolean flag = false;
            int fast = 0;
            for (int slow = 0; slow < t.length(); slow++) {
                if (s.charAt(fast) != t.charAt(slow)) { // differ more than one char
                    if (flag) {
                        return false;
                    }
                    flag = true;
                    slow--;
                }
                fast++;
            }
            return true;
        }
        // s = a b c d f
        //         f
        // t = a b d f
        //       s

        private boolean isOneChangeDistance(String s, String t) {
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) { // differ more than one char
                    if (flag) {
                        return false;
                    } else {
                        flag = true;
                    }
                }
            }
            return flag; // if s and t are exactly the same: false
        }
        // s = a b c d f
        //         f
        // t = a b e d f
        //         s
    }
}

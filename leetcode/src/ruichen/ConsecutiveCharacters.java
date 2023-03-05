package ruichen;

public class ConsecutiveCharacters {
    // TC = O(n), SC = O(1)
    class Solution {
        public int maxPower(String s) {
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

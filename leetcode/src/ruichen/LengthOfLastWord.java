package ruichen;

public class LengthOfLastWord {
    // TC = O(n), SC = O(1)
    class Solution {
        public int lengthOfLastWord(String s) {
            // corner case
            if (s == null || s.length() == 0) {
                return 0;
            }
            // trim trailing spaces
            int i = s.length() - 1, len = 0;
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // compute length of last word
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
                len++;
            }
            return len;
        }
    }
}

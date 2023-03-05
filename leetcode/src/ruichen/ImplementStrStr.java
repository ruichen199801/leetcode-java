package ruichen;

public class ImplementStrStr {
    // s1: a b c d e
    // s2: c d e

    // TC = O(m * n), SC = O(1)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null || haystack.length() < needle.length()) {
                return -1;
            }

            if (needle.isEmpty()) {
                return 0;
            }

            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                int j = 0;
                while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }

            return -1;
        }
    }
}

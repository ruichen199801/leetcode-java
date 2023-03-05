package ruichen;

public class ValidAnagram {
    // s and t consist of lowercase English letters
    // Two Pass
    // 1st: maintain a count[26], ++ for s and -- for t
    // 2nd: check if every digit == 0

    // Follow up: What if the inputs contain unicode characters?
    // Use a hash table instead of a fixed size counter.

    // TC = O(n), SC = O(26) = O(1)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int si = s.charAt(i) - 'a';
                int ti = t.charAt(i) - 'a';
                count[si]++;
                count[ti]--;
            }
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    // #409 https://leetcode.com/problems/longest-palindrome
    // Hash Table, String

    class Solution1 {
        // TC = O(n), SC = O(n)
        public int longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    set.remove(c);
                    count++;
                } else {
                    set.add(c);
                }
            }
            return set.isEmpty() ? count * 2 : count * 2 + 1;
        }
    }

    class Solution2 {
        // TC = O(n), SC = O(1)
        public int longestPalindrome(String s) {
            int[] count = new int[128]; // 128 is the number of ASCII characters
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)]++;
            }
            int maxLen = 0, oddCount = 0;
            for (int c : count) {
                if (c % 2 == 0) {
                    maxLen += c;
                } else {
                    maxLen += c - 1;
                    oddCount++;
                }
            }
            return maxLen + (oddCount > 0 ? 1 : 0);
        }
    }

}

package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    // #3 https://leetcode.com/problems/longest-substring-without-repeating-characters/
    // String, Sliding Window

    class Solution {

        public int lengthOfLongestSubstring(String s) {

            // string vs char array
            // string is immutable: every attempt to modify the characters in a string would only get a defensive copy of a new string
            // so we would use the toCharArray() method to convert string to char array for convenient modification of characters
            // the toCharArray() method takes O(n) time and O(n) space, but usually the abstract algorithm is intended to be in-place

            // p w w k e w
            //     i
            // j
            // set {p w}

            // Brute force: O(n^3) time, double for-loop + substring api
            // Sliding window:
            // Time complexity = O(2n) = O(n), b/c in worst case i and j both look at all characters
            // Space complexity = O(n) when the whole string contains no repeating character

            if (s == null || s.length() == 0) {
                return 0;
            }
            Set<Character> set = new HashSet<>();
            int i = 0, j = 0, max = 0;
            while (i < s.length()) {
                char ch = s.charAt(i);
                while (set.contains(ch)) {
                    // keep moving pointer j and removing its corresponding element in the set until the set no longer contains "ch"
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(ch);
                max = Math.max(max, i - j + 1); // window length
                i++;
            }
            return max;
        }
    }
}

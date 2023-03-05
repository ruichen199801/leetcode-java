package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    // TC = O(2n) = O(n), in worst case i and j both look at all characters
    // SC = O(n), when the whole string contains no repeating character
    class Solution {
        public int lengthOfLongestSubstring(String s) {
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

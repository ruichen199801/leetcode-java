package ruichen;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    // #159 https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
    // String, Sliding window
    // TC = O(n), SC = O(3) = O(1) (at most 3 unique elements in the hash map)

    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            // change k to 2
            if (s == null || s.length() == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int i = 0, j = 0;
            while (i < s.length()) {
                char cur = s.charAt(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                int count = map.size();
                while (count > 2 && j < s.length()) {
                    char ch = s.charAt(j);
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                        count--;
                    }
                    j++;
                }
                i++;
                max = Math.max(max, i - j); // only update when expanding window
            }
            return max;
        }
    }
}

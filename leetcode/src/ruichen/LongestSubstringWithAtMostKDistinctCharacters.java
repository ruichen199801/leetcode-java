package ruichen;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    // #340 https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    // String, Sliding Window
    // TC = O(2n) = O(n), SC = O(min(k, n)) = O(max size of hash map)

    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            // e c e b a, k = 2
            //       i
            //     j
            // map: {e:0, c:1, b:1}
            // count = map.size()
            // global max
            if (s == null || s.length() == 0 || k == 0) {
                return 0;
            }
            Map<Character, Integer> map = new HashMap<>();
            int max = 0;
            int i = 0, j = 0;
            while (i < s.length()) {
                char cur = s.charAt(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                int count = map.size();
                while (count > k && j < s.length()) {
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

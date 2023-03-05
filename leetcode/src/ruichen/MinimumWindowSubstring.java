package ruichen;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    //         0 1 2 3 4 5 6 7 8 9 10 11 12
    //    s = "A D O B E C O D E B  A  N  C"
    //         i -- slow pointer, move to contract found window to shave off unnecessary prefix
    //         j -- fast pointer, move to expand new window that satisfies

    //  count = 3 -- number of unique characters left to be found to include into the window substring
    //            -- > 0: continue expanding
    //            -- == 0: begin extracting

    //  left = 0 -- left and right bound we've found of the min window substring that contains t
    //  right = 12
    //  minLength = 13 -- for convience, actually left and right are enough
    //  isFound = false -- if t is nowhere to be found in s, return ""

    // Map: t = "ABC"
    // A: 1
    // B: 1
    // C: 1

    // N: size of string s, M: size of string t
    // Time complexity = O(2N + M) = O(N + M), m for creating hashmap and 2n for sliding window
    // in worst case slow and fast pointer both sees all elements
    // Space complexity = O(M) for hashmap storage
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0) {
                return "";
            }

            int left = 0, right = s.length() - 1, minLength = s.length();
            boolean isFound = false;

            // create hashmap
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : t.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // expand window
            int i = 0, j = 0, count = map.size();
            while (j < s.length()) {
                char endChar = s.charAt(j);
                if (map.containsKey(endChar)) {
                    map.put(endChar, map.get(endChar) - 1);
                    if (map.get(endChar) == 0) {
                        count--; // count remains still when same char in t appears more than once
                    }
                }
                j++;

                if (count > 0) {
                    continue; // skip the checks below until all the chars of t are found in s
                }

                // contract window
                while (count == 0) {
                    char startChar = s.charAt(i);
                    if (map.containsKey(startChar)) {
                        map.put(startChar, map.get(startChar) + 1);
                        if (map.get(startChar) == 1) {
                            count++; // break and start the next search
                        }
                    }
                    i++;
                }

                // update result
                if (j - i < minLength) {
                    left = i;
                    right = j;
                    minLength = j - i;
                    isFound = true;
                }
            }

            return isFound ? s.substring(left - 1, right) : ""; // [left - 1, right - 1]
        }
    }
}

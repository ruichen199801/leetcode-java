package ruichen;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    // #387 https://leetcode.com/problems/first-unique-character-in-a-string/
    // Hash Table
    // TC = O(n), SC = O(n)

    class Solution {
        public int firstUniqChar(String s) {
            // Two pass + hash map
            Map<Character, Integer> map = new HashMap<>(); // store <char, count>
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.get(ch) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}

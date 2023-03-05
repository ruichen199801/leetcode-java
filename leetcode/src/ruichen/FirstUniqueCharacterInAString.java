package ruichen;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    // Two pass + hash map
    // TC = O(n), SC = O(n)
    class Solution {
        public int firstUniqChar(String s) {
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

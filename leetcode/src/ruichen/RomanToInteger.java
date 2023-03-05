package ruichen;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    // TC = O(1), SC = O(1) (constant b/c input string size + hashmap size are fixed)
    class Solution {
        public int romanToInt(String s) {
            Map<String, Integer> map = new HashMap<>();
            map.put("M", 1000);
            map.put("CM", 900);
            map.put("D", 500);
            map.put("CD", 400);
            map.put("C", 100);
            map.put("XC", 90);
            map.put("L", 50);
            map.put("XL", 40);
            map.put("X", 10);
            map.put("IX", 9);
            map.put("V", 5);
            map.put("IV", 4);
            map.put("I", 1);
            // linear scan the string from left to right
            // read one or two letter(s) at a time
            int num = 0, i = 0;
            while (i < s.length()) {
                if (i + 1 < s.length()) {
                    String twoDigits = s.substring(i, i + 2); // substring: [start, end)
                    // read two characters if applicable
                    if (map.containsKey(twoDigits)) {
                        num += map.get(twoDigits);
                        i += 2;
                        continue;
                    }
                }
                // else read one character
                num += map.get(s.substring(i, i + 1));
                i++;
            }
            return num;
        }
    }
}

package ruichen;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    // step 1: calculate max string length
    // step 2: iterate maxLength times to add results
    // step 3: trim right spaces

    // TC = O(m * n), m = maximum string length, n = # of strings (after split)
    // SC = O(n), split into a string array
    class Solution {
        public List<String> printVertically(String s) {
            List<String> result = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return result;
            }
            String[] words = s.split(" ");
            int maxLen = getMaxLength(words);
            for (int i = 0; i < maxLen; i++) {
                StringBuilder cur = new StringBuilder();
                for (String word : words) {
                    if (i >= word.length()) {
                        cur.append(" ");
                    } else {
                        cur.append(word.charAt(i));
                    }
                }
                result.add(trimRight(cur.toString()));
            }
            return result;
        }

        private int getMaxLength(String[] words) {
            int maxLen = 0;
            for (String word : words) {
                maxLen = Math.max(maxLen, word.length());
            }
            return maxLen;
        }

        // allows leading space, only remove trailing space
        private String trimRight(String word) {
            int len = word.length();
            for (int i = len - 1; i >= 0; i--) {
                if (word.charAt(i) != ' ') {
                    return word.substring(0, i + 1); // [0, i]
                }
            }
            return null; // all spaces
        }
    }
}

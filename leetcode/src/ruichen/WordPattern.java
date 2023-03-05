package ruichen;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // Same as #205
    // TC = O(max(n1, n2)), n1 = # of chars, n2 = # of words
    // SC = O(m + 26) = O(m), 2 hash maps, m = # of unique words
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            Map<Character, String> charToWord = new HashMap<>();
            Map<String, Character> wordToChar = new HashMap<>();
            String[] words = s.split(" ");
            if (words.length != pattern.length()) {
                return false;
            }
            for (int i = 0; i < pattern.length(); i++) {
                char ch = pattern.charAt(i);
                String word = words[i];
                if (!charToWord.containsKey(ch)) {
                    if (wordToChar.containsKey(word)) {
                        return false;
                    } else {
                        charToWord.put(ch, word);
                        wordToChar.put(word, ch);
                    }
                } else if (!wordToChar.containsKey(word) || !charToWord.get(ch).equals(word) ||
                        wordToChar.get(word) != ch) {
                    return false;
                }
            }
            return true;
        }
    }
}

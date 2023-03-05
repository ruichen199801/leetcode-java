package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    // s = "3[a2[c]]"
    //              i

    // countStack [ : stores duplicate times of the current word
    // wordStack [  : stores "prefix" of the current word
    // number = 2
    // word = "accaccacc"

    // TC = O(n * m), n = word length, m = count
    // SC = O(n + n + m) = O(2n + m) = O(n + m) (string builder + stack)
    class Solution {
        public String decodeString(String s) {
            Deque<Integer> countStack = new ArrayDeque<>();
            Deque<String> wordStack = new ArrayDeque<>();
            int number = 0;
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    number = 10 * number + ch - '0'; // "23[a]", 23 = 2 * 10 + 3
                } else if (Character.isLetter(ch)) {
                    word.append(ch);
                } else if (ch == '[') {
                    countStack.offerFirst(number);
                    wordStack.offerFirst(word.toString());
                    number = 0;
                    word = new StringBuilder();
                } else { // ch == ']'
                    StringBuilder duplicateWord = new StringBuilder(wordStack.pollFirst());
                    int count = countStack.pollFirst();
                    for (int j = 0; j < count; j++) {
                        duplicateWord.append(word);
                    }
                    word = duplicateWord;
                }
            }
            return word.toString();
        }
    }
}

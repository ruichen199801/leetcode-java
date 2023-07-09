package ruichen;

public class StringCompression {
    // TC = O(n), SC = O(1)
    class Solution {
        public int compress(char[] chars) {
            //   a a b b c c c
            //               j
            // [ a 2 b 2 c 3
            //               i
            //   count: 1
            int i = 0;     // result ] i  j [ area to explore
            int count = 1;
            for (int j = 0; j < chars.length; j++) {
                // if we compare j and j-1, we will not trigger the write for the last count
                if (j + 1 < chars.length && chars[j] == chars[j + 1]) {
                    count++;
                } else {
                    chars[i++] = chars[j];
                    if (count > 1) {
                        String digits = String.valueOf(count);
                        // count could be more than one digit
                        for (char digit : digits.toCharArray()) {
                            chars[i++] = digit;
                        }
                    }
                    count = 1;
                }
            }
            return i;
        }
    }
}

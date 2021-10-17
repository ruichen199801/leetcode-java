package ruichen;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    // #6 https://leetcode.com/problems/zigzag-conversion/
    // String
    // TC = O(n), SC = O(n)

    class Solution {
        public String convert(String s, int numRows) {

            // s = "PAYP AL ISHI RI NG", numRows = 4
            // output = "sb0 sb1 sb2 sb3" = "PIN ALSIG YAHR PI"

            // a list of sbs
            // ================
            // sb0: [ P   I   N
            // sb1: [ A L S I G
            // sb2: [ Y A H R
            // sb3: [ P   I
            // ================
            //        t b t b t
            // t = top to bottom, b = bottom to top

            // Construct a list of StringBuilders to store different sections (rows) of the answer
            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                rows.add(new StringBuilder());
            }
            // Scan the input string sequentially, and update our StringBuilders "vertically"
            int charIndex = 0;
            while (charIndex < s.length()) {
                // Update from top to bottom ("Zig")
                for (int i = 0; i < numRows && charIndex < s.length(); i++) {
                    rows.get(i).append(s.charAt(charIndex));
                    charIndex++;
                }
                // Update from bottom to top ("Zag")
                for (int j = numRows - 2; j >= 1 && charIndex < s.length(); j--) {
                    rows.get(j).append(s.charAt(charIndex));
                    charIndex++;
                }
            }
            // Concatenate the rows together to be the final result
            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }
            return result.toString();
        }
    }
}

package ruichen;

import java.util.Arrays;

public class IsomorphicStrings {

    // #205 https://leetcode.com/problems/isomorphic-strings/
    // String, Hash Table
    // TC = O(n), SC = O(1) (256 == 1)

    class Solution {
        public boolean isIsomorphic(String s, String t) {
            // foo bar
            // f-b, b-f
            // o-a, a-o
            // expect o-a, not o-r, return false
            int[] sToT = new int[256]; // 256 ascii characters, 0 - 255
            Arrays.fill(sToT, -1);
            int[] tToS = new int[256];
            Arrays.fill(tToS, -1);
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i), c2 = t.charAt(i);
                if (sToT[c1] == -1 && tToS[c2] == -1) {
                    sToT[c1] = c2;
                    tToS[c2] = c1;
                } else if (!(sToT[c1] == c2 && tToS[c2] == c1)) {
                    return false;
                }
            }
            return true;
        }
    }
}

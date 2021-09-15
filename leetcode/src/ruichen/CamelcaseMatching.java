package ruichen;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

    // #1023 https://leetcode.com/problems/camelcase-matching/
    // Two Pointers, String
    // TC = O(l * (m + n)), l = len(queries), m = len(query), n = len(pattern)
    // SC = O(l)

    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> result = new ArrayList<>();
            for (String query : queries) {
                result.add(matches(query, pattern));
            }
            return result;
        }

        private boolean matches(String query, String pattern) {

            // FooBarTest
            //       i
            // FoBar
            //      j

            // FootBall
            //         i
            // FoBaT
            //     j

            int i = 0, j = 0;
            while (i < query.length()) {
                char ch = query.charAt(i);
                if (j < pattern.length() && ch == pattern.charAt(j)) {
                    j++;
                } else if (Character.isUpperCase(ch)) {
                    return false;
                }
                i++;
            }
            return j == pattern.length();
        }
    }
}

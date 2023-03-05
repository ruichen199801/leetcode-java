package ruichen;

import java.util.Arrays;

public class AssignCookies {
    // TC = O(n log n + n), SC = O(n), n = # of elements in g and s
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (s == null || s.length == 0) {
                return 0;
            }
            Arrays.sort(g);
            Arrays.sort(s);
            int i = s.length - 1, j = g.length - 1;
            int count = 0;
            while (i >= 0 && j >= 0) {
                if (s[i] >= g[j]) {
                    count++;
                    i--;
                }
                j--;
            }
            return count;
        }
    }
}

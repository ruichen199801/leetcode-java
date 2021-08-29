package ruichen;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    // #119 https://leetcode.com/problems/pascals-triangle-ii/
    // Dynamic Programming
    // TC = O(n^2), SC = O(n)

    class Solution {
        public List<Integer> getRow(int rowIndex) { // 0-indexed!!!
            // 1 ... cur[i] = prev[i - 1] + prev[i] ... 1
            // we only maintain a single cur list and keep updating it
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int i = 0; i <= rowIndex; i++) {
                // scan from end of list, such that prev[i - 1] and prev[i] remains unmodified when we update cur[i]
                for (int j = i - 1; j >= 1; j--) {
                    cur.set(j, cur.get(j) + cur.get(j - 1)); // O(1)
                }
                if (i > 0) {
                    cur.add(1);
                }
            }
            return cur;
        }
    }
}

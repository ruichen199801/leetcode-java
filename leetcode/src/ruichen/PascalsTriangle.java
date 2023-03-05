package ruichen;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    // 1 ... cur[i] = prev[i - 1] + prev[i] ... 1
    // TC = O(n^2) (the double for-loop), SC = O(n^2) (the result list)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) { // row
                List<Integer> cur = new ArrayList<>();
                cur.add(1);
                for (int j = 1; j < i; j++) { // column
                    List<Integer> prev = result.get(i - 1);
                    cur.add(prev.get(j - 1) + prev.get(j));
                }
                if (i > 0) {
                    cur.add(1);
                }
                result.add(cur);
            }
            return result;
        }
    }
}

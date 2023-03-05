package ruichen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    // first sort the matrix by the first index
    // example input: [[1,3],[8,10],[15,18],[2,6]]
    // after sorting: [[1,3],[2,6],[8,10],[15,18]]
    // if (result is empty || no overlap) {
    //     add current interval into result
    // }
    // else if (overlap: previous interval's second index >= current interval's first index) {
    //     merge: set previous interval's second index to max(the two intervals' second index)
    //            e.g. [1,3], [2,6] -> [1,6], [1, 4] [2, 3] -> [1, 4]
    // }

    // TC: depends on sorting, O(n log n) for Java
    // SC: O(n) for sorting (O(n) for storing output, may not count)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return null;
            }
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            List<int[]> result = new ArrayList<>();
            for (int[] curr : intervals) {
                if (result.isEmpty()) {
                    result.add(curr);
                }
                int[] prev = result.get(result.size() - 1);
                if (prev[1] >= curr[0]) { // overlap: merge
                    prev[1] = Math.max(prev[1], curr[1]); // e.g. [[1,4],[2,3]] -> [1,4]
                    // we can modify int[] reference directly, do not need to remove then add
                } else {
                    result.add(curr);
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
}

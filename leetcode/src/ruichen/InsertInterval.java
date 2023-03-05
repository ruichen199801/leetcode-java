package ruichen;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    // TC = O(n), SC = O(n)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            // edge case: empty input intervals
            if (intervals.length == 0) {
                return new int[][]{newInterval};
            }

            List<int[]> result = new ArrayList<>();
            int i = 0;

            // add all intervals that end before the newInterval starts
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
                i++;
            }

            // merge intervals that overlap with the newInterval
            int[] mergedInterval = newInterval;
            while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                mergedInterval[0] = Math.min(mergedInterval[0], intervals[i][0]);
                mergedInterval[1] = Math.max(mergedInterval[1], intervals[i][1]);
                i++;
            }
            result.add(mergedInterval);

            // add all remaining intervals
            while (i < intervals.length) {
                result.add(intervals[i]);
                i++;
            }

            // convert list to array
            return result.toArray(new int[result.size()][]);
        }
    }
}

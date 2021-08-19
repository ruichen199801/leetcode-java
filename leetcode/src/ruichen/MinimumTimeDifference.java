package ruichen;

import java.util.List;

public class MinimumTimeDifference {

    // #539 https://leetcode.com/problems/minimum-time-difference/
    // Array, Sorting
    // TC = O(n) (line 14), SC = O(1) (fixed-length bucket)

    class Solution {
        public int findMinDifference(List<String> timePoints) {
            boolean[] bucket = new boolean[60 * 24];
            for (String timePoint : timePoints) {
                // "23:59" -> ["23", "59"]
                String[] t = timePoint.split(":");
                int hours = Integer.parseInt(t[0]);
                int minutes = Integer.parseInt(t[1]);
                int total = hours * 60 + minutes;
                // edge case: duplicate time points such as "1:00", "1:00"
                if (bucket[total]) {
                    return 0;
                }
                bucket[total] = true;
            }

            // min
            // general case -> prev, cur
            // edge case: "23:59", "00:00" -> first, cur
            int min = Integer.MAX_VALUE, prev = -1, cur = -1, first = -1;
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i]) {
                    // fix first at first time point, then only move cur and prev
                    if (prev == -1) { // 1st time
                        first = i;
                        prev = i;
                    } else { // 2nd, 3rd, ...
                        cur = i;
                        min = Math.min(min, cur - prev);
                        prev = cur;
                    }
                }
            }
            min = Math.min(min, 60 * 24 - cur + first);
            return min;
        }
    }
}

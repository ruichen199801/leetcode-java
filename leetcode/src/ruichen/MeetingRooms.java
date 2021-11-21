package ruichen;

import java.util.Arrays;

public class MeetingRooms {

    // #252 https://leetcode.com/problems/meeting-rooms/
    // Array, Sorting
    // TC = O(n log n + n) (sorting + for loop), SC = O(log n) in average, O(n) worst case (sorting)

    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            // corner case
            if (intervals == null || intervals.length == 0) {
                return true;
            }
            Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
            int[] pre = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] cur = intervals[i];
                // [2, 4] [3, 5]    [2, 5] [3, 4]
                if (pre[1] > cur[0]) {
                    return false;
                }
                pre = cur;
            }
            return true;
        }
    }
}

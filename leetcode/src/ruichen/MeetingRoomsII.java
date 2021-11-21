package ruichen;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    // #253 https://leetcode.com/problems/meeting-rooms-ii/
    // Array, Sorting, Heap
    // TC = O(n log n + n) (sorting + for loop), SC = O(n + k) (sorting + heap)

    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            // sort array by start time
            Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
            // maintain a min heap to store end time
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            // add first meeting if none
            minHeap.offer(intervals[0][1]);
            // if an assigned room is free, poll it from heap, otherwise offer a new room into heap
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= minHeap.peek()) {
                    minHeap.poll();
                }
                // update old room / add new room, we need to offer to heap anyway
                minHeap.offer(intervals[i][1]);
            }
            return minHeap.size();
        }
    }
}

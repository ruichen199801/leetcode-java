package ruichen;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {

    // #1353 https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
    // Array, Greedy, Heap
    // TC = O(d + n log n), SC = O(n)

    class Solution {
        public int maxEvents(int[][] events) {

            /* Greedy + min heap:
            Sort events increased by start time.
            Priority queue keeps the current open events.
            Each day, we add new events starting on day d to the queue pq.
            Also we remove the events that are already closed.
            Then we greedily attend the event that ends soonest.
            If we can attend a meeting, we increment the result res.
            */

            if (events == null || events.length == 0) {
                return 0;
            }
            Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int count = 0, i = 0;
            for (int day = 1; day <= 100000; day++) {
                while (!minHeap.isEmpty() && minHeap.peek() < day) {
                    minHeap.poll();
                }
                while (i < events.length && events[i][0] == day) { // start time = current day
                    minHeap.offer(events[i++][1]); // offer end time
                }
                if (!minHeap.isEmpty()) {
                    minHeap.poll();
                    count++;
                }
            }
            return count;
        }
    }
}

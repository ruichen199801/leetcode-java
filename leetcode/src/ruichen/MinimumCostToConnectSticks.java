package ruichen;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    // Greedy: Always pick two sticks with the smallest costs
    // TC = O(n log n), SC = O(n)
    class Solution {
        public int connectSticks(int[] sticks) {
            if (sticks == null || sticks.length <= 1) {
                return 0;
            }
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int stick : sticks) {
                minHeap.offer(stick);
            }
            int cost = 0;
            for (int i = 0; i < sticks.length - 1; i++) { // Merge n - 1 times
                int stick1 = minHeap.poll();
                int stick2 = minHeap.poll();
                int newStick = stick1 + stick2;
                cost += newStick;
                minHeap.offer(newStick);
            }
            return cost;
        }
    }
}

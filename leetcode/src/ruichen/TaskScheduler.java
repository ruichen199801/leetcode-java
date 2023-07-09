package ruichen;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    // TC = O(n log n), SC = O(n)
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] frequencies = new int[26];
            for (char task : tasks) {
                frequencies[task - 'A']++;
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
            for (int freq : frequencies) {
                if (freq > 0) {
                    maxHeap.offer(freq);
                }
            }

            int intervals = 0;

            // Greedy: for each n+1 interval, pick the most freq task (), and put pack the remaining freq-1 task
            while (!maxHeap.isEmpty()) {
                // Store used frequencies for the current round
                List<Integer> temp = new ArrayList<>();

                for (int i = 0; i <= n; i++) {
                    if (!maxHeap.isEmpty()) {
                        if (maxHeap.peek() > 1) {
                            // We can't add it immediately back to heap due to the n+1 interval limitation on the same task
                            temp.add(maxHeap.poll() - 1);
                        } else {
                            maxHeap.poll();
                        }
                    }

                    intervals++;

                    // Last interval < n+1: break loop early, otherwise more intervals are counted
                    if (maxHeap.isEmpty() && temp.isEmpty()) {
                        break;
                    }
                }

                maxHeap.addAll(temp);
            }

            return intervals;
        }
    }
}

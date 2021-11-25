package ruichen;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    // #973 https://leetcode.com/problems/k-closest-points-to-origin/
    // Array, Divide and Conquer, Heap

    class Solution {
        // Max heap solution: TC = O(n log k), SC = O(k) (if we do not consider the output matrix)
        // We can also use quick select to solve this problem.
        public int[][] kClosest(int[][] points, int k) {
            int[][] res = new int[k][2];
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
            for (int[] p : points) {
                maxHeap.offer(p);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
            int i = 0;
            while (!maxHeap.isEmpty()) {
                res[i++] = maxHeap.poll();
            }
            return res;
        }
    }
}

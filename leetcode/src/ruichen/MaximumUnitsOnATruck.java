package ruichen;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {

    // #1710 https://leetcode.com/problems/maximum-units-on-a-truck/
    // Array, Sorting

    class Solution1 {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            // sort array -> greedy (pick boxes with most capacity first)
            // TC = O(n log n) (sort) + O(n) (iterate) = O(n log n), SC = O(n) (sort)
            Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]); // sort by decreasing box capacity
            int maxUnit = 0;
            for (int[] box : boxTypes) {
                int boxNum = Math.min(truckSize, box[0]);
                maxUnit += boxNum * box[1];
                truckSize -= boxNum;
                if (truckSize == 0) {
                    break;
                }
            }
            return maxUnit;
        }
    }

    class Solution2 {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            // use a PQ
            // TC = (2n log n) = O(n log n) (offer + poll from heap), SC = O(n) (heap size)
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((b1, b2) -> b2[1] - b1[1]);
            for (int[] box: boxTypes) {
                maxHeap.offer(box);
            }
            int maxUnit = 0;
            while (!maxHeap.isEmpty()) { // avoid NPE
                int[] box = maxHeap.poll();
                int boxNum = Math.min(box[0], truckSize);
                maxUnit += boxNum * box[1];
                truckSize -= boxNum;
                if (truckSize == 0) {
                    break;
                }
            }
            return maxUnit;
        }
    }
}

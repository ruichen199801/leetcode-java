package ruichen;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    // #373 https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    // Heap

    class Solution {

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            // Very similar to merge k sorted lists
            // TC = O(log k * k), SC = O(k)

            List<List<Integer>> pairs = new ArrayList<>();
            if (nums1.length == 0 || nums2.length == 0 || k == 0) {
                return pairs;
            }

            // maintain a minHeap to store {pair1, pair2}
            // pair1, pair2: {index in nums1, index in nums2}
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> nums1[pair1[0]] - nums1[pair2[0]] + nums2[pair1[1]] - nums2[pair2[1]]);

            // seed minHeap with k elements: {0, 0}, {0, 1}, ..., {0, k-1 or nums2.length - 1}
            for (int i = 0; i < nums2.length; i++) {
                if (i == k) {
                    break;
                }
                minHeap.offer(new int[] {0, i});
            }

            // poll the smallest from minHeap, offer the next unchecked pair
            while (k-- > 0 && !minHeap.isEmpty()) {
                int[] smallest = minHeap.poll();
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[smallest[0]]);
                pair.add(nums2[smallest[1]]);
                pairs.add(pair);
                // when heap size < k
                if (smallest[0] + 1 == nums1.length) {
                    continue; // if index in nums1 grows out of bound, do not add new elements and pop old ones in the next iteration
                }
                // when heap size >= k
                minHeap.offer(new int[] {smallest[0] + 1, smallest[1]}); // start from the next index of the current smallest
            }
            return pairs;
        }
    }
}

package ruichen;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    // #973 https://leetcode.com/problems/k-closest-points-to-origin/
    // Array, Divide and Conquer, Heap
    // See #347, #692

    class Solution1 {
        // Max heap solution: TC = O(n log k), SC = O(k) (if we do not consider the output matrix)
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

    class Solution2 {
        // Quick select solution: TC = O(n), SC = O(n)
        public int[][] kClosest(int[][] points, int k) {
            quickSelect(points, 0, points.length - 1, k);
            return Arrays.copyOf(points, k);
        }

        // partition based on pivot
        private void quickSelect(int[][] points, int left, int right, int k) {
            // recursion base case
            if (left >= right) {
                return;
            }

            int pivotIndex = partition(points, left, right);
            // look at left half, see if we find all the k elements left
            int numSmaller = pivotIndex - left + 1;

            if (numSmaller == k) {
                return;
            } else if (numSmaller > k) {
                quickSelect(points, left, pivotIndex - 1, k);
            } else {
                quickSelect(points, pivotIndex + 1, right, k - numSmaller);
            }
        }

        // choose pivot, left half is smaller than pivot, right half larger
        private int partition(int[][] points, int left, int right) {
            int[] pivot = points[right];
            int i = left;

            // i: known bound for smaller elements, inclusive
            // j: unknown bound
            for (int j = left; j < right; j++) {
                if (distance(points[j]) < distance(pivot)) { // <= also works
                    swap(points, i, j);
                    i++;
                }
            }

            swap(points, i, right);
            return i;
        }

        private int distance(int[] point) {
            return point[0] * point[0] + point[1] * point[1];
        }

        private void swap(int[][] points, int i, int j) {
            int[] temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }
    }
}

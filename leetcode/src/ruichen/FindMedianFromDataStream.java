package ruichen;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    // #295 https://leetcode.com/problems/find-median-from-data-stream/
    // Heap, Design
    // TC: addNum: O(log n), findMedian: O(1); SC = O(n)

    class MedianFinder {

        // [a,b,c,d,e]
        private PriorityQueue<Integer> left; // [a,b,c]
        private PriorityQueue<Integer> right; // [d,e]

        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
            right = new PriorityQueue<>(); // minHeap
        }

        public void addNum(int num) {
            // maintain even size b/t 2 heaps
            if (left.size() == right.size()) {
                right.offer(num);
                left.offer(right.poll()); // add to left
            } else {
                left.offer(num);
                right.offer(left.poll()); // add to right
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return 1.0 * (left.peek() + right.peek()) / 2;
            } else {
                return 1.0 * left.peek();
            }
        }
    }
}

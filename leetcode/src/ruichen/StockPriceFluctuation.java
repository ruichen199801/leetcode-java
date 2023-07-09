package ruichen;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPriceFluctuation {
    // update(): TC = O(log n), n = # of elements
    // current(): TC = O(1)
    // max(), min(): TC = O(k log n), k = # of old invalid prices
    // Map and heap: SC = O(n)
    class StockPrice {
        private Map<Integer, Integer> timeMap; // <ts, price>
        private PriorityQueue<int[]> maxHeap;  // [ts, price]
        private PriorityQueue<int[]> minHeap;
        int latestTimestamp; // for O(1) current()

        public StockPrice() {
            timeMap = new HashMap<>();
            maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            latestTimestamp = 0;
        }

        public void update(int timestamp, int price) {
            // heap.remove(element) takes O(n), but heap.poll() takes O(log n);
            // So instead of adding new price and removing old price from heap in update(),
            // we can perform the removal logic in min() and max() to save time.
            timeMap.put(timestamp, price);
            maxHeap.offer(new int[] {timestamp, price});
            minHeap.offer(new int[] {timestamp, price});
            latestTimestamp = Math.max(latestTimestamp, timestamp);
        }

        public int current() {
            return timeMap.get(latestTimestamp);
        }

        public int maximum() {
            int[] top = maxHeap.peek();
            while (top[1] != timeMap.get(top[0])) {
                // Lazy update: The map is up-to-date, but the heap still has old values.
                maxHeap.poll();
                top = maxHeap.peek();
            }
            return top[1];
        }

        public int minimum() {
            int[] top = minHeap.peek();
            while (top[1] != timeMap.get(top[0])) {
                minHeap.poll();
                top = minHeap.peek();
            }
            return top[1];
        }
    }
}

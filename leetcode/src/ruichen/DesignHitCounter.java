package ruichen;

import java.util.ArrayList;
import java.util.List;

public class DesignHitCounter {
    // Assume one hit at each timestamp, and timestamp increments from 1
    // hit(): TC = O(1), getHits(): TC = O(log n)
    // list: SC = O(n)
    class HitCounter {
        private List<Integer> timestamps;

        public HitCounter() {
            timestamps = new ArrayList<>();
        }

        public void hit(int timestamp) {
            timestamps.add(timestamp);
        }

        public int getHits(int timestamp) {
            int n = timestamps.size();
            if (n == 0) return 0;
            int left = 0, right = n - 1;
            int rangeStart = timestamp - 299; // Find past 300 seconds, not timestamp 300

            // Sorted array: Run binary search to find the smallest index >= rangeStart;
            // Duplicate timestamps might exist, we need to return the earliest timestamp for duplicates.
            while (left < right - 1) {
                int mid = left + (right - left) / 2;
                if (timestamps.get(mid) < rangeStart) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (timestamps.get(left) >= rangeStart) {
                return n - left; // Use index differences to count hits
            } else if (timestamps.get(right) >= rangeStart) {
                return n - right;
            }
            return 0;
        }
    }
}

package ruichen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    // #981 https://leetcode.com/problems/time-based-key-value-store/
    // Binary Search, Hash Table, Design

    class TimeMap {

        private Map<String, List<Data>> map;
        // key1: [<value1, ts1>, <value2, ts2>]
        // define a class to store <value, ts> as tuples
        // time complexity: set O(1) get O(log n)
        // space complexity: O(n) to store n entries

        /** Initialize your data structure here. */
    public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Data(value, timestamp));
        }

        public String get(String key, int timestamp) {
            // binary search: less than or equal to the input timestamp
            if (!map.containsKey(key)) {
                return "";
            }
            List<Data> list = map.get(key);
            int left = 0, right = list.size() - 1;
            while (left < right - 1) { // exit when 2 elements left to avoid infinite loop
                int mid = left + (right - left) / 2;
                if (list.get(mid).timestamp == timestamp) {
                    return list.get(mid).value; // timestamp is unique
                } else if (list.get(mid).timestamp < timestamp) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (list.get(right).timestamp <= timestamp) {
                return list.get(right).value; // check right first to satisfy "closest"
            }
            if (list.get(left).timestamp <= timestamp) {
                return list.get(left).value;
            }
            return "";
        }

        class Data {
            private String value;
            private int timestamp;
            public Data(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    }

}

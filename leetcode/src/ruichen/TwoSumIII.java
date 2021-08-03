package ruichen;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIII {

    // #170 https://leetcode.com/problems/two-sum-iii-data-structure-design/
    // Hash Table

    class TwoSum {

        // handle duplicate numbers: store <num, freq> in hash table rather than hash set
        // operation (time) complexity: add(num): O(1), find(value): O(n)
        // space complexity: O(n)

        private Map<Integer, Integer> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int complement = value - entry.getKey();
                if (map.containsKey(complement)) {
                    if (complement != entry.getKey()) { // 3 + 5 = 8
                        return true;
                    } else if (entry.getValue() > 1) { // 4 + 4 = 8
                        return true;
                    }
                }
            }
            return false;
        }
    }

}

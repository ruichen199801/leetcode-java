package ruichen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    // #1207 https://leetcode.com/problems/unique-number-of-occurrences/
    // Array, Hash Table
    // TC = O(n), SC = O(n)

    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int val : arr) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (set.contains(entry.getValue())) {
                    return false;
                }
                set.add(entry.getValue());
            }
            return true;
        }
    }
}

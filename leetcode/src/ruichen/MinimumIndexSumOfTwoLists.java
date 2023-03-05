package ruichen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    // TC = O(l1 + l2) linear, SC = O(l1 * x), x = average string length
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> result = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            for (int j = 0; j < list2.length; j++) {
                if (map.containsKey(list2[j])) {
                    int sum = j + map.get(list2[j]);
                    if (sum < minSum) {
                        result.clear(); // clear all previous results before introducing the latest minSum
                        result.add(list2[j]);
                        minSum = sum;
                    } else if (sum == minSum) {
                        result.add(list2[j]);
                    }
                }
            }
            return result.toArray(new String[result.size()]);
        }
    }
}

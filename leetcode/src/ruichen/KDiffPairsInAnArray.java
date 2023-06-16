package ruichen;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    // nums[i] == nums[j] + k
    // TC = O(n), SC = O(n)
    class Solution {
        public int findPairs(int[] nums, int k) {
            // Assumption: k >= 0
            int count = 0;
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                if (k == 0) {
                    if (entry.getValue() >= 2) {
                        count++;
                    }
                } else {
                    if (freqMap.containsKey(entry.getKey() + k)) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}

package ruichen;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    // Similar question: #532 (asking for unique pairs)
    class Solution1 {
        // Method 1.1: hash map + iterate over array
        // TC = O(n), SC = O(n)
        public int countKDifference(int[] nums, int k) {
            int count = 0;
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            for (int num : nums) {
                count += freqMap.getOrDefault(num + k, 0);
            }
            return count;
        }
    }

    class Solution2 {
        // Method 1.2: hash map + iterate over map
        // TC = O(n), SC = O(n)
        public int countKDifference(int[] nums, int k) {
            int count = 0;
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                int num = entry.getKey();
                int freq = entry.getValue();
                count += freqMap.getOrDefault(num + k, 0) * freq;
            }
            return count;
        }
    }

    class Solution3 {
        // Method 2: counter array
        // TC = O(n), SC = O(1)
        public int countKDifference(int[] nums, int k) {
            int count = 0;
            int[] freq = new int[101]; // 1 <= nums[i] <= 100
            for (int num : nums) {
                freq[num]++;
            }
            for (int num : nums) {
                if (num + k <= 100) {
                    count += freq[num + k];
                }
            }
            return count;
        }
    }
}

package ruichen;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    class Solution1 {
        // Hash Map: TC = O(n), SC = O(n)
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }

    class Solution2 {
        // Bit Manipulation: TC = O(n), SC = O(1)
        // x ^ x = 0, x ^ 0 = x
        public int singleNumber(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            return xor;
        }
    }
}

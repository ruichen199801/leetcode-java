package ruichen;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialQuadruplets {
    // nums[a] + nums[b] == nums[d] - nums[c]
    // map: <nums[a] + nums[b], count>
    // x x x x x x x x
    //         a b

    // TC = O(n^2), SC = O(n^2)
    class Solution {
        public int countQuadruplets(int[] nums) {
            int n = nums.length;
            int count = 0;

            Map<Integer, Integer> freqMap = new HashMap<>();
            freqMap.put(nums[n - 1] - nums[n - 2], 1); // this case won't be covered in the loop

            for (int b = n - 3; b >= 1; b--) {
                // two sum approach: increment count if we find a match in the map
                for (int a = b - 1; a >= 0; a--) {
                    count += freqMap.getOrDefault(nums[a] + nums[b], 0);
                }

                // current b is c in the next for-loop
                for (int d = n - 1; d > b; d--) {
                    freqMap.put(nums[d] - nums[b], freqMap.getOrDefault(nums[d] - nums[b], 0) + 1);
                }
            }

            return count;
        }
    }
}

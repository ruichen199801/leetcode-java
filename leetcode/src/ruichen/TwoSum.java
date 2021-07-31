package ruichen;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {

            // #1 https://leetcode.com/problems/two-sum/
            // TC = O(n), SC = O(n)
            // Array, Hash Table

            Map<Integer, Integer> numMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                // add array elements and check whether complement exists in hash table on the fly in one-pass
                if (numMap.containsKey(complement)) {
                    return new int[] {numMap.get(complement), i};
                }
                numMap.put(nums[i], i);
            }
            return null;
        }
    }

}

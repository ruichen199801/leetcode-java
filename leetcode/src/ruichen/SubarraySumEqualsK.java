package ruichen;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // #560 https://leetcode.com/problems/subarray-sum-equals-k/
    // Array, Hash Table, Prefix Sum
    // TC = O(n), SC = O(n)

    class Solution {
        public int subarraySum(int[] nums, int k) {
            // Prefix Sum: calculate the total of any slice of the array in O(n) time
            // maintain the sum so far for each i in nums[i]
            // case 1: prefixSum[i] == k, count++
            // case 2: sum(i, j) = sum(0, j) - sum(0, i)
            //         count += # of times prefixSum[i] - k appears

            // <prefixSum, frequency>
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, count = 0;
            for (int num : nums) {
                sum += num;
                // case 1
                if (sum == k) {
                    count++;
                }
                // case 2
                count += map.getOrDefault(sum - k, 0);
                // record the prefixSum at current index in hashmap
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}

package ruichen;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    // Prefix sum with some math
    // curSum[i] = k * x + ci
    // curSum[j] = k * y + cj
    // curSum[i] - curSum[j] = k * constant + (ci - cj)
    // ci = curSum[i] % k, cj = curSum[j] % k
    // if and only if (curSum[i] % k == curSum[j] % k),
    // curSum[i] - curSum[j] = k * constant, Q.E.D.
    // Conclusion: store mod in hashmap instead of sum itself

    // TC = O(n), SC = O(n)
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>(); // maintain a hash map to store <sum % k, index>
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sum %= k;
                if (sum == 0 && i > 0) {
                    return true;
                }
                if (map.containsKey(sum) && i - map.get(sum) > 1) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return false;
        }
    }
}

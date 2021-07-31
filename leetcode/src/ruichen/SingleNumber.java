package ruichen;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	
	// #136 https://leetcode-cn.com/problems/single-number/
	// Bit Manipulation, Hash Table
	
	class Solution1 {
	    public int singleNumber(int[] nums) {
	        // Hash Map: TC = O(n), SC = O(n)
	        Map<Integer, Integer> freq = new HashMap<>();
	        for (int num: nums) {
	            freq.put(num, freq.getOrDefault(num, 0) + 1);
	        }
	        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
	            if (entry.getValue() == 1) {
	                return entry.getKey();
	            }
	        }
	        return -1;
	    }
	}
	
	class Solution2 {
	    public int singleNumber(int[] nums) {
	        // Bit Manipulation: TC = O(n), SC = O(1)
	        // x ^ x = 0, x ^ 0 = x
	        int xor = 0;
	        for (int num : nums) {
	            xor ^= num;
	        }
	        return xor;
	    }
	}

}

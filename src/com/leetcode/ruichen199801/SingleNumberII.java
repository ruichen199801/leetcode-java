package com.leetcode.ruichen199801;

public class SingleNumberII {
	
	class Solution {
	    
	    // #137 https://leetcode-cn.com/problems/single-number-ii/
	    // Hash Set/Hash Map: TC = O(n), SC = O(n)
	    // Bit Manipulation: TC = O(n), SC = O(1)

	    public int singleNumber(int[] nums) {
	    	
	        // x ^ x = 0 -> if x ^ x = 1, must appear once or three times

	        // initiaize:
	        // e.g. x = 2  0b 0000001
	        //   once = 0  0b 0000000
	        //  twice = 0  0b 0000000

	        // when x appears once:
	        // e.g. x = 2  0b 0000001
	        //   once = 2  0b 0000001
	        //  twice = 0  0b 0000000

	        // when x appears twice:
	        // e.g. x = 2  0b 0000001
	        //   once = 0  0b 0000000
	        //  twice = 2  0b 0000001

	        // when x appears three times:
	        // e.g. x = 2  0b 0000001
	        //   once = 0  0b 0000000
	        //  twice = 0  0b 0000000

	        // therefore, we return once

	        int once = 0;
	        int twice = 0;
	        for (int num : nums) {
	            once = ~twice & (once ^ num);
	            twice = ~once & (twice ^ num);
	        }
	        return once;     
	    }
	}

}

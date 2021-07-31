package ruichen;

public class ReverseInteger {
	
	class Solution {

	    // #7 https://leetcode.com/problems/reverse-integer/
	    // Math
	    // TC = O(log x), SC = O(1)

	    public int reverse(int x) {
	    	
	        // Consider overflow!
	        // Integer.MIN_VALUE: -2^31 = -xxxx8
	        // Integer.MAX_VALUE: 2^31 - 1 = xxxx7
	        // 123 % 10 = 3, 123 / 10 = 12
	    	
	        int res = 0;
	        while (x != 0) {
	            int pop = x % 10; // 3 -> 2 -> 1
	            x /= 10; // 12 -> 1 -> 0
	            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7) ) {
	                return 0;
	            }
	            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8) ) {
	                return 0;
	            }
	            res = res * 10 + pop; // (*)  3 -> 32 -> 321
	            // derive the overflow checkpoint based on the (*) equation
	        }
	        return res;
	    }
	}

}

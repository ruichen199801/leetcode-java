package ruichen;

public class PowerOfTwo {
	
	class Solution {
	    // #231 https://leetcode-cn.com/problems/power-of-two/
	    // Bit Manipulation, Math
	    // TC = O(1), SC = O(1)
	    public boolean isPowerOfTwo(int n) {
	        // corner case: negative number
	        if (n <= 0) {
	            return false;
	        }
	        int count = 0;
	        for (int i = 0; i < 32; i++) {
	            if (((n >> i) & 1) == 1) { // must have '()'!
	                count += 1;
	            }
	        }
	        return count == 1;
	    }
	}

}

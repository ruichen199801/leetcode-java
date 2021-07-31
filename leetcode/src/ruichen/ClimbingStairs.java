package ruichen;

public class ClimbingStairs {
	
	class Solution1 {

		// #70 https://leetcode.com/problems/climbing-stairs/
	    // DP, TC = O(n), SC = O(n)

	    public int climbStairs(int n) {
	        if (n == 1) {
	            return 1;
	        }
	        int[] res = new int[n];
	        res[0] = 1;
	        res[1] = 2;
	        for (int i = 2; i < res.length; i++) {
	            res[i] = res[i - 2] + res[i - 1];
	        }
	        return res[n - 1];
	    }
	}
	
	class Solution2 {
	    // DP, TC = O(n), SC = O(1) (improved)
	    public int climbStairs(int n) {
	        if (n == 1) {
	            return 1;
	        }
	        int a = 1;
	        int b = 2;
	        while (n > 2) {
	            int temp = b;
	            b = a + b;
	            a = temp;
	            n--;
	        }
	        return b;
	    }
	}

}

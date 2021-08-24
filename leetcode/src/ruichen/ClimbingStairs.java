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
		public int climbStairs(int n) {
			// DP, TC = O(n), SC = O(1) (improved)
			// Fib(n) = Fib(n - 1) + Fib(n - 2), 1 <= n <= 45
			if (n == 1) {
				return 1;
			}
			int first = 1;
			int second = 2;
			for (int i = 3; i <= n; i++) {
				int third = first + second;
				first = second;
				second = third;
			}
			return second;
		}
	}

}

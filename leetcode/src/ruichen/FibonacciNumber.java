package ruichen;

public class FibonacciNumber {

	// #509 https://leetcode.com/problems/fibonacci-number/
	// same problem as #70 Climbing Stairs

	class Solution {
		public int fib(int n) {
			// DP with constant space: TC = O(n), SC = O(1)
			if (n == 0) {
				return 0;
			}
			int a = 0;
			int b = 1;
			for (int i = 2; i <= n; i++) {
				int temp = b;
				b = a + b;
				a = temp;
			}
			return b;
		}
	}

}

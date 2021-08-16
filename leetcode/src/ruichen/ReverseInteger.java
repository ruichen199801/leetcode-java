package ruichen;

public class ReverseInteger {

	// #7 https://leetcode.com/problems/reverse-integer/
	// Math
	// TC = O(n), n = number of digits in input x, SC = O(1)

	class Solution {
		public int reverse(int x) {
			// 321 -> 123
			// -321 -> -123
			long result = 0; // "bait" overflow cases out, then eliminate them
			while (x != 0) {
				int remainder = x % 10;
				result = result * 10 + remainder;
				if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
					return 0;
				}
				x /= 10;
			}
			return (int) result;
		}
	}

}

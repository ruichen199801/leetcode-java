package com.leetcode.ruichen199801;

public class FibonacciNumber {
	
	class Solution {
	    // #509 https://leetcode-cn.com/problems/fibonacci-number/
	    // DP, TC = O(n), SC = O(1)
	    public int fib(int n) {
	        if (n == 0) {
	            return 0;
	        }
	        int a = 0;
	        int b = 1;
	        while (n > 1) {
	            int temp = b;
	            b = a + b;
	            a = temp;
	            n--;
	        }
	        return b;
	    }
	}

}

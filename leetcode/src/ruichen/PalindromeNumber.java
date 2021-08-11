package ruichen;

public class PalindromeNumber {
	
	class Solution {

	    // #9 https://leetcode.com/problems/palindrome-number/
	    // Math
	    // TC = O(log n), SC = O(1)

	    public boolean isPalindrome(int x) {
	        if (x < 0 || (x % 10 == 0 && x != 0)) {
	            return false;
	        }
	        // to avoid overflow, we only reverse right half and compare with left half
	        int rev = 0;
	        //                    x  rev 
	        // odd bits: 12321 -> 12 123
	        // even bits: 1221 -> 12 12
	        while (x > rev) {
	            int temp = x % 10;
	            x /= 10;
	            rev = rev * 10 + temp;
	        } 
	        // handle odd case
	        if (x < rev) {
	            rev /= 10;
	        }
	        return x == rev;
	        // return x == rev || x == rev / 10;
	    }
	}

}

package ruichen;

public class LongestPalindromicSubstring {
	
	class Solution {

	    // #5 https://leetcode-cn.com/problems/longest-palindromic-substring/
	    // String
	    // TC = O(n^2), SC = O(1)

	    public String longestPalindrome(String s) {
	    	
	        // Expand from middle > DP
	        // Case 1: "racecar"    <- e ->
	        // Case 2: "aabccbaa"  <- c c ->  
	    	
	        if (s == null || s.length() < 1) {
	            return "";
	        } 
	        int start = 0, end = 0; // the answer to return 
	        for (int i = 0; i < s.length(); i++) {
	            int len1 = expandFromMiddle(s, i, i); // Case 1
	            int len2 = expandFromMiddle(s, i, i + 1); // Case 2
	            int len = Math.max(len1, len2);
	            
	            // Determine whether to update it into final result
	            
	            if (len > end - start) {
	            	
	                // "racecar"  i = 3 (e), start = 0, end = 6, curLen = 7
	                // "aabccbaa" i = 3 (c c), start = 0, end = 7, curLen = 8
	            	
	                start = i - (len - 1) / 2;
	                end = i + len / 2; 
	            }
	        }
	        return s.substring(start, end + 1);
	    }

	    private int expandFromMiddle(String s, int left, int right) {
	        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	            left--;
	            right++;
	        }
	        
	        // "racecar", starting from "e, 3"
	        // final iteration: left = 0, right = 6
	        // left-- = -1, right++ = 7
	        
	        return right - left - 1;    
	    }
	}

}

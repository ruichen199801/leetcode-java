package ruichen;

public class PalindromePartitioningII {
	
	class Solution {

	    // #132 https://leetcode.com/problems/palindrome-partitioning-ii/
	    // Dynamic Programming
	    // TC = O(n^3), SC = O(n)
	      
	    public int minCut(String s) {
	        if (s == null || s.length() <= 1) {
	            return 0; 
	        }
	        char[] arr = s.toCharArray();
	        int n = arr.length;
	        // find and record minCut for sub-problems: s.length() = 0, 1, .., s
	        //      a  b  c  b  a  a
	        // j -> 0          i-1   
	        // when i = 5, j = [0, 4]
	        int[] res = new int[n + 1]; // n + 1, not n!
	        res[0] = 0;
	        res[1] = 0;
	        for (int i = 2; i < n + 1; i++) {
	            int minCut = Integer.MAX_VALUE;
	            for (int j = 0; j < i; j++) {    
	                if (isPalindrome(arr, j, i - 1)) { // i - 1, not i!
	                    // if already palindrome, do not need to make cuts
	                    if (j == 0) {            
	                        minCut = 0; 
	                        break;
	                    } else {
	                        minCut = Math.min(minCut, res[j] + 1); // make a cut, so we have + 1
	                    }                            
	                }   
	            }
	            res[i] = minCut; 
	        }
	        return res[n];
	    }

	    private boolean isPalindrome(char[] arr, int i, int j) {
	        while (i < j) {
	            if (arr[i] != arr[j]) {
	                return false;
	            }
	            i++;
	            j--;
	        }
	        return true;
	    }
	}

}

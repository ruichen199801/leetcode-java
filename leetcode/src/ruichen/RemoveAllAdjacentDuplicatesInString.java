package ruichen;

public class RemoveAllAdjacentDuplicatesInString {
	
	class Solution {

	    // #1047 https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
	    // Stack, Two Pointers
	    // TC = O(n), SC = O(1)
	    
	    public String removeDuplicates(String S) {
	    	
	    	// pay special attention to the cases below:	    	
	        // test case 1: "aaaaa" -> "a", error: "", explanation: remove odd pairs at a time
	        // test case 2: "abbaca" -> "ca", error: "c", explanation: return i + 1
	    	
	        char[] arr = S.toCharArray();
	        int i = 0; // simulate a stack
	        for (int j = 1; j < arr.length; j++) {
	            if (i == -1 || arr[j] != arr[i]) { 
	                i++;
	                arr[i] = arr[j];
	            } else {
	                i--;
	            }
	        }
	        // constructor: String(char[] array, start index, length)
	        return new String(arr, 0, i + 1);
	    }
	}
	
}



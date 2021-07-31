package ruichen;

public class RemoveElement {
	
	class Solution {

	    // #27 https://leetcode.com/problems/remove-element/
	    // Array, Two Pointers
	    // TC = O(n), SC = O(1) (in-place)

	    public int removeElement(int[] nums, int val) {
	        int i = 0;
	        for (int j = 0; j < nums.length; j++) {
	            if (nums[j] != val) {
	                nums[i++] = nums[j];            
	            } 
	        }
	        return i;
	    }
	}

}

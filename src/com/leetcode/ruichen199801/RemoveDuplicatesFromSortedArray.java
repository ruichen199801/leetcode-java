package com.leetcode.ruichen199801;

public class RemoveDuplicatesFromSortedArray {

	class Solution {
        
                // #26 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
		// Array, Two Pointers
		// TC = O(n), SC = O(1)

		public int removeDuplicates(int[] nums) {
			if (nums.length == 0) {
				return 0;
			}
			int i = 0;
			for (int j = 1; j < nums.length; j++) {
				if (nums[i] != nums[j]) {
					nums[++i] = nums[j];
				}
			}
			return i + 1;
		}

	}

}

package ruichen;

public class MergeSortedArray {

	class Solution1 {
        
                // #88 https://leetcode-cn.com/problems/merge-sorted-array/
		// Array, Two Pointers
		// Solution 1 (SC bad)
		// Treat nums1 as result array, copy m elements of nums1 to nums1Copy, then
		// perform merge operation on nums1Copy and nums2.
		// TC = O(m + n), SC = O(m)

		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int[] nums1Copy = new int[m];
			copyArray(nums1Copy, nums1, m);
			int p1 = 0, p2 = 0, p = 0;
			while (p1 < m && p2 < n) {
				if (nums1Copy[p1] <= nums2[p2]) {
					nums1[p++] = nums1Copy[p1++];
				} else {
					nums1[p++] = nums2[p2++];
				}
			}
			while (p1 < m) {
				nums1[p++] = nums1Copy[p1++];
			}
			while (p2 < n) {
				nums1[p++] = nums2[p2++];
			}
		}

		private void copyArray(int[] array1, int[] array2, int length) {
			for (int i = 0; i < length; i++) {
				array1[i] = array2[i];
			}
		}
	}

	class Solution2 {

		// Solution 2 (best)
		// Set two pointers to move backwards to save space
		// nums1 = [1, 2, 3, 0, 0, 0]
		// <- p1 <- p
		// nums2 = [1, 2, 3]
		// <- p2
		// TC = O(m + n), SC = O(1)

		public void merge(int[] nums1, int m, int[] nums2, int n) {
			int p = m + n - 1, p1 = m - 1, p2 = n - 1;
			while (p1 >= 0 && p2 >= 0) {
				// reverse order!
				if (nums1[p1] >= nums2[p2]) {
					nums1[p--] = nums1[p1--];
				} else {
					nums1[p--] = nums2[p2--];
				}
			}
			// no need to check p1, already in place!
			while (p2 >= 0) {
				nums1[p--] = nums2[p2--];
			}
		}

	}

}

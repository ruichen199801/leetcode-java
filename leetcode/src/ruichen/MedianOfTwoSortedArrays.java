package ruichen;

public class MedianOfTwoSortedArrays {

    // #4 https://leetcode.com/problems/median-of-two-sorted-arrays/
    // Array, Binary Search

    class Solution {
        // Binary Search
        // TC: O(log m + n), SC: O(1)
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if (len % 2 != 0) {
                return kth(nums1, 0, nums2, 0, len / 2 + 1);
            } else {
                return 1.0 * (kth(nums1, 0, nums2, 0, len / 2) +
                        kth(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
            }
        }

        private int kth(int[] a, int aleft, int[] b, int bleft, int k) {
            // a, b: original array
            // aleft, bleft: start point after offset

            // 3 base cases
            if (aleft >= a.length) {
                return b[bleft + k - 1];
            }
            if (bleft >= b.length) {
                return a[aleft + k - 1];
            }
            if (k == 1) {
                return Math.min(a[aleft], b[bleft]);
            }

            // binary search
            int amid = aleft + k / 2 - 1;
            int bmid = bleft + k / 2 - 1;
            int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
            int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
            // tail recursion
            if (aval <= bval) {
                return kth(a, amid + 1, b, bleft, k - k / 2);
            } else {
                return kth(a, aleft, b, bmid + 1, k - k / 2);
            }
        }
    }
}

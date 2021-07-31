package ruichen;

public class SearchInsertPosition {

    class Solution {

        // #35 https://leetcode.com/problems/search-insert-position/
        // Binary Search
        // TC = O(log n), SC = O(1)

        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
        /* iterate through every element
           [1, 3, 5, 6] where target == 7: left = 3 + 1, right = 3
           [1, 3, 5, 6] where target == 0: left = 0, right = 0 - 1
           return left
        */
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    return mid;
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

}

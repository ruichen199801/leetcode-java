package ruichen;

public class SearchInRotatedSortedArrayII {
    // TC = O(log n) in average, O(n) worst case (all elements are the same); SC = O(1)
    class Solution {
        public boolean search(int[] nums, int target) {
            // move pointers to skip duplicates
            if (nums == null || nums.length == 0) {
                return false;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                while (left + 1 <= right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left <= right - 1 && nums[right] == nums[right - 1]) {
                    right--;
                }
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < nums[left]) { // 6 7 1 2 3 4 5, t = 4
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else { // 3 4 5 6 7 1 2, t = 4
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return false;
        }
    }
}

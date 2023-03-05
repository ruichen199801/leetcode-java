package ruichen;

public class SearchInRotatedSortedArray {
    // Intuition: binary search + identify which part is sorted, and which part is rotated
    // Only aim for the sorted part to figure out the if condition
    // TC = O(log n), SC = O(1)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < nums[left]) {
                    // rotate mid sorted
                    // 6 7 1 2 3 4 5, t = 4
                    // l     m     r
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    // sorted mid rotate
                    // 4 5 6 7 1 2 3, t = 4
                    // l     m     r
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}

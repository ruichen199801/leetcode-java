package ruichen;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    // #34 https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    // Array, Binary Search
    // TC = O(log n), SC = O(1)

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int first = search(nums, target, true);
        int last = search(nums, target, false);
        return new int[] {first, last};
    }

    // a generalized method to find boundary for both first and last occurrence
    // only 2 differences between first and last algorithm: 1) mid == target 2) post-process
    private int search(int[] nums, int target, boolean isFirst) {
        // 5, 7, 7, 8, 8, 10, T = 8
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        // post-processing the two elements left
        if (isFirst) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
        } else {
            if (nums[right] == target) {
                return right;
            }
            if (nums[left] == target) {
                return left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.print(Arrays.toString(obj.searchRange(nums, target))); // Expected output: [3, 4]
    }
}

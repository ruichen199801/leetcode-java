package ruichen;

public class RotateArray {

    // #189 https://leetcode.com/problems/rotate-array/
    // Array, Two Pointers
    // TC = O(n), SC = O(1)

    class Solution {
        public void rotate(int[] nums, int k) {
            // reverse-reverse
            // 1 2 3 4 | 5 6 7 -> 4 3 2 1 | 7 6 5 -> 5 6 7 1 2 3 4
            k %= nums.length;
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, nums.length - k, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }

        private void reverse(int[] nums, int i, int j) {
            while (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }
}

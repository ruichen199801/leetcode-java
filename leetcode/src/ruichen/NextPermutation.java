package ruichen;

public class NextPermutation {

    // #31 https://leetcode.com/problems/next-permutation/
    // Array, Two Pointers
    // TC = O(n), SC = O(1)

    class Solution {
        public void nextPermutation(int[] nums) {
            // 9 4 7 5 3 1
            //   i   j
            // Step 1: swap i, j
            // Step 2: reverse [i+1:]
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) { // =
                i--;
            }
            if (i < 0) {
                reverse(nums, 0);
                return;
            }
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) { // =
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i + 1);
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int[] nums, int i) {
            int start = i, end = nums.length - 1;
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
}

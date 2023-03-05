package ruichen;

public class SortColors {
    // x x x y y y ? ? ? z z z
    // i
    // j
    //                       k

    // TC = O(n), SC = O(1)
    class Solution {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }
            int i = 0, j = 0, k = nums.length - 1;
            while (j <= k) {
                if (nums[j] == 0) {
                    swap(nums, i, j);
                    i++;
                    j++;
                } else if (nums[j] == 1) {
                    j++;
                } else if (nums[j] == 2) {
                    swap(nums, j, k);
                    k--;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

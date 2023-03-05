package ruichen;

public class MoveZeros {
    // TC = O(n), SC = O(1) (in-place)
    class Solution1 {
        public void moveZeroes(int[] nums) {
            int i = 0;
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count++;
                } else {
                    nums[i++] = nums[j];
                }
            }
            while (count > 0) {
                nums[i++] = 0;
                count--;
            }
        }
    }

    class Solution2 {
        // i: left bound, processed part
        // j: right bound, to-be-processed part
        // linear scan the array with j
        // swap i and j every time we find a non-zero element
        public void moveZeroes(int[] nums) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    swap(nums, i, j);
                    i++;
                }
            }
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}

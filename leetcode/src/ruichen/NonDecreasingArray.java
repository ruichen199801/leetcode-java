package ruichen;

public class NonDecreasingArray {
    // TC = O(n), SC = O(1)
    class Solution {
        public boolean checkPossibility(int[] nums) {
            // store the index of the element that needs to be modified (if any)
            int index = -1;

            for (int i = 0; i < nums.length - 1; i++) {
                // cannot modify more than one element
                if (nums[i] > nums[i + 1]) {
                    if (index != -1) {
                        return false;
                    }
                    index = i;
                }
            }

            // 1 2 3 4
            if (index == -1) {
                return true;
            }

            // 2 5 3 4 -> 2 3 3 4 (index = 5, 3 > 2)
            if (index == 0 || nums[index + 1] >= nums[index - 1]) {
                return true;
            }
            // 2 3 1 4 -> 2 3 3 4 (index = 3, 4 > 3)
            if (index == nums.length - 2 || nums[index + 2] >= nums[index]) {
                return true;
            }

            // 2 5 1 4 (change 5 to 1, or change 1 to 5: both won't work)
            return false;
        }
    }
}

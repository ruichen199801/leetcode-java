package ruichen;

public class ShuffleTheArray {

    // #1470 https://leetcode.com/problems/shuffle-the-array/
    // Array

    class Solution1 {
        // Method 1: TC = O(n), SC = O(2 * n)
        public int[] shuffle(int[] nums, int n) {
            int[] result = new int[2 * n];
            int p1 = 0, p2 = n;
            for (int i = 0; i < 2 * n; i += 2) {
                result[i] = nums[p1++];
                result[i + 1] = nums[p2++];
            }
            return result;
        }
    }

    class Solution2 {
        // Method 2: TC = O(2 * n), SC = O(1)
        public int[] shuffle(int[] nums, int n) {
            // 1 <= nums[i] <= 1000
            // "store" x, y pairs using the right half of the input array
            for (int i = n; i < 2 * n; i++) {
                nums[i] = nums[i] * 1024 + nums[i - n]; // -> even faster: bit manipulation
            }
            // "retrieve" stored values
            int idx = 0;
            for (int i = n; i < 2 * n; i++, idx += 2) {
                nums[idx] = nums[i] % 1024;
                nums[idx + 1] = nums[i] / 1024;
            }
            return nums;
        }
    }
}

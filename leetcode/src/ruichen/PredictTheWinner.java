package ruichen;

public class PredictTheWinner {
    class Solution1 {
        // Recursion: TC = O(2^n), SC = O(n)
        public boolean PredictTheWinner(int[] nums) {
            return offset(nums, 0, nums.length - 1) >= 0;
        }

        private int offset(int[] nums, int start, int end) {
            // base case
            if (start == end) {
                return nums[start];
            }
            // pick from start
            int moveA = nums[start] - offset(nums, start + 1, end);
            // pick from end
            int moveB = nums[end] - offset(nums, start, end - 1);

            return Math.max(moveA, moveB);
        }
    }

    class Solution2 {
        // DP: TC = O(n^2), SC = O(n)
        public boolean PredictTheWinner(int[] nums) {
            int len = nums.length;
            int[] offset = new int[len];
            // i = j
            for (int i = 0; i < len; i++) {
                offset[i] = nums[i];
            }
            // traverse order: result: (i - j) = (0 - 4)
            // so start from (3 - 4), (2 - 3 4), (1 - 2 3 4), (0 - 1 2 3 4)
            for (int i = len - 2; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    offset[j] = Math.max(nums[i] - offset[j], nums[j] - offset[j - 1]);
                }
            }
            return offset[len - 1] >= 0;
        }
    }
}

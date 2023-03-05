package ruichen;

public class TrappingRainWater {
    class Solution1 {
        // Unit of water stored = min(L, R) - height[i]
        // L - max height on the left, R - max height on the right
        // iterate through array to get leftMax and rightMax for each i, then subtract
        // TC = O(n), SC = O(n)
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int sum = 0;
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            leftMax[0] = height[0];
            rightMax[height.length - 1] = height[height.length - 1];
            for (int i = 1; i < height.length; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }
            for (int i = height.length - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }
            for (int i = 1; i < height.length - 1; i++) {
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return sum;
        }
    }

    class Solution2 {
        // Use two pointers to optimize memory storage in one iteration
        // height[i] xxxxxxxxx
        //           i -> <- j
        // TC = O(n), SC = O(1)
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int sum = 0;
            int l = 0, r = height.length - 1;
            int leftMax = height[l], rightMax = height[r];
            while (l < r) {
                if (leftMax < rightMax) {
                    l++;
                    leftMax = Math.max(leftMax, height[l]);
                    sum += leftMax - height[l];
                } else {
                    r--;
                    rightMax = Math.max(rightMax, height[r]);
                    sum += rightMax - height[r];
                }
            }
            return sum;
        }
    }
}

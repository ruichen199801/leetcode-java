package ruichen;

public class ContainerWithMostWater {
    // Two pointers: area = (r - l) * min(height[l], height[r])
    // TC = O(n), SC = O(1)
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int max = 0;
            while (l < r) {
                int h = Math.min(height[l], height[r]);
                int area = (r - l) * h;
                max = Math.max(max, area);
                if (height[l] < height[r]) {
                    l++;
                } else if (height[l] > height[r]) {
                    r--;
                } else {
                    l++;
                    r--;
                }
            }
            return max;
        }
    }
}

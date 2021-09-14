package ruichen;

public class KokoEatingBananas {

    // #875 https://leetcode.com/problems/koko-eating-bananas/
    // Binary Search
    // TC = O(n log m), n = number of piles (findMax), m = max value of each element in piles (binary search bound: 1 - m)
    // SC = O(1)

    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1, right = findMax(piles);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (canEat(piles, h, mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
            // [3], h = 2
            // l = 1, r = 3, m = 2, hour = 2
            // l = 1, r = 2, m = 1, hour = 3
            // l = 2, r = 2, m = 2, hour = 2
            // l = 2, r = 1
        }

        private boolean canEat(int[] piles, int h, int mid) {
            // piles = [3,6,7,11], h = 8, mid = 5
            // 11 % 5 = 1, 11 / 5 = 2, res = 3
            int hour = 0;
            for (int pile : piles) {
                if (pile % mid != 0) {
                    hour += pile / mid + 1;
                } else {
                    hour += pile / mid;
                }
            }
            return hour <= h;
        }

        private int findMax(int[] piles) {
            int max = piles[0];
            for (int pile : piles) {
                max = Math.max(max, pile);
            }
            return max;
        }
    }
}

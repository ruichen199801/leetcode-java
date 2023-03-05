package ruichen;

public class KokoEatingBananas {
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
        }

        private boolean canEat(int[] piles, int h, int mid) {
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

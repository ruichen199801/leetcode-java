package ruichen;

public class CanPlaceFlowers {
    // Linear scan to find # of empty spots to compare with n
    // TC = O(n), SC = O(1)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {

            int count = 0, len = flowerbed.length;
            for (int i = 0; i < len; i++) {
                int pre = i - 1 < 0 ? 0 : flowerbed[i - 1];
                int cur = flowerbed[i];
                int post = i + 1 >= len ? 0 : flowerbed[i + 1];
                if (pre == 0 && cur == 0 && post == 0) {
                    flowerbed[i] = 1; // mark as planted
                    count++;
                }
            }
            return count >= n; // a minor optimization: return early in the loop if we've already found count >= n.
        }
    }
}

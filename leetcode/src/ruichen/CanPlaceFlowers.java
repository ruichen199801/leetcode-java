package ruichen;

public class CanPlaceFlowers {

    // #605 https://leetcode.com/problems/can-place-flowers/
    // Array
    // TC = O(n), SC = O(1)

    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // linear scan to find # of empty spots to compare with n
            // no algorithm, simply test your patience to handle the annoying edge cases in a loop :(
            // "look at myself, look to the left and look to the right"
            // 0 0 xxxxx
            // xxxxx 0 0 0 xxxxx
            // xxxxx 0 0
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

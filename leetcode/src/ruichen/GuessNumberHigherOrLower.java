package ruichen;

public class GuessNumberHigherOrLower {

    // #374 https://leetcode.com/problems/guess-number-higher-or-lower/
    // Binary Search
    // TC = O(log n), SC = O(1)

    /**
     * Forward declaration of guess API.
     * num:   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    public class Solution {
        public int guessNumber(int n) { // map n to n+1
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (guess(mid + 1) == 0) {
                    return mid + 1;
                } else if (guess(mid + 1) == 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

        private int guess(int i) {
            return -1; // to play around IntelliJ's syntax check
        }
    }
}

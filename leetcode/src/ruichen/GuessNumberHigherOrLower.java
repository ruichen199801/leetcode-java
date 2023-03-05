package ruichen;

public class GuessNumberHigherOrLower {
    // TC = O(log n), SC = O(1)
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

        private int guess(int i) { // placeholder
            return -1;
        }
    }
}

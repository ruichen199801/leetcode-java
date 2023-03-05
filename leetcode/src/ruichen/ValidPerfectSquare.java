package ruichen;

public class ValidPerfectSquare {
    // Binary search, same as #69 Sqrt(x)
    // TC = O(log n), SC = O(1)
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            int left = 2, right = num / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long squareNum = (long) mid * mid; // avoid overflow
                if (num == squareNum) {
                    return true;
                } else if (num > squareNum) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}

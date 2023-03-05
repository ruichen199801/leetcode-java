package ruichen;

public class SqrtX {
    // 0 <= x <= 2^31 - 1
    // We need to avoid overflow: mid * mid could be 2^31/2 * 2^31/2.
    // TC = O(log n), SC = O(1)
    class Solution {
        public int mySqrt(int x) {
            if (x < 2) {
                return x;
            }
            int left = 1, right = x / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long num = (long) mid * mid;
                if (num == x) {
                    return mid;
                } else if (num > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1; // +1: rule out possible result, -1: return right
                }
            }
            return right;
        }
    }
}

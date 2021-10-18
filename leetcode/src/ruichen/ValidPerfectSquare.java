package ruichen;

public class ValidPerfectSquare {

    // #367 https://leetcode.com/problems/valid-perfect-square/
    // Binary Search
    // TC = O(log n), SC = O(1)

    class Solution {
        public boolean isPerfectSquare(int num) {
            // Binary search, same as #69 Sqrt(x)
            if (num < 2) {
                return true;
            }
            int left = 2, right = num / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long squareNum =  (long) mid * mid; // avoid overflow
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

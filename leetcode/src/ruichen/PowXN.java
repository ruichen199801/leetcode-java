package ruichen;

public class PowXN {

    // #50 https://leetcode.com/problems/powx-n/
    // Math, Recursion
    // TC = O(log n), SC = O(log n)

    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }
            double half = myPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                if (n > 0) {
                    return half * half * x;
                } else {
                    return half * half / x;
                }
            }
        }
    }
}

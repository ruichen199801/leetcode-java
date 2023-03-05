package ruichen;

public class NthTribonacciNumber {
    // DP, TC = O(n), SC = O(1)
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            int first = 0;
            int second = 1;
            int third = 1;
            for (int i = 3; i <= n; i++) {
                int sum = first + second + third;
                first = second;
                second = third;
                third = sum;
            }
            return third;
        }
    }
}

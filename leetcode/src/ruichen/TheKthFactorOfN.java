package ruichen;

import java.util.ArrayList;
import java.util.List;

public class TheKthFactorOfN {

    // #1492 https://leetcode.com/problems/the-kth-factor-of-n/
    // Math

    class Solution1 {
        // Method 1: TC = O(n), SC = O(1)
        public int kthFactor(int n, int k) {
            for (int i = 1; i <= n / 2; i++) { // minor improvement: n -> n/2
                if (n % i == 0) {
                    k--;
                }
                if (k == 0) {
                    return i;
                }
            }
            return k == 1 ? n : -1;
        }
    }

    class Solution2 {
        // Method 2: TC = O(sqrt(n)), SC = O(min(sqrt(n), k))
        public int kthFactor(int n, int k) {
            // n = 12, k = 2, sqrtN = 3
            // list = [1, 2, 3]
            List<Integer> divisors = new ArrayList<>();
            int sqrtN = (int) Math.sqrt(n);
            for (int i = 1; i <= sqrtN; i++) {
                if (n % i == 0) {
                    k--;
                    divisors.add(i);
                }
                if (k == 0) {
                    return i;
                }
            }
            // we're here b/c k-th factor is not found
            // if n is a perfect square, we have to skip the duplicate in the divisor list
            if (sqrtN * sqrtN == n) {
                k++;
            }
            int size = divisors.size();
            if (k <= size) {
                return n / divisors.get(size - k);
            } else {
                return -1;
            }
        }
    }
}

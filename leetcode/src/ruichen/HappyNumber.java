package ruichen;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    // #202 https://leetcode.com/problems/happy-number/ -> #142
    // Hash Table, Two Pointers

    class Solution1 {

        // Hash Table: TC = O(log n), SC (= TC) = O(log n)

        public boolean isHappy(int n) {
            Set<Integer> seen = new HashSet<>();
            while (n != 1 && !seen.contains(n)) {
                seen.add(n);
                n = getNext(n);
            }
            return n == 1;
        }

        private int getNext(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return sum;
        }
    }

    class Solution2 {

        // Floyd's Cycle-Finding Algorithm: TC = O(log n), SC = O(1)

        public boolean isHappy(int n) {
            int slow = n, fast = getNext(n);
            while (slow != fast) {
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }
            return slow == 1;
        }

        private int getNext(int n) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return sum;
        }
    }
}

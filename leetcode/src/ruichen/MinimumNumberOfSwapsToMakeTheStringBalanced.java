package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    class Solution {
        // Greedy: minSwap = (mismatch + 1) / 2
        // TC = O(n), SC = O(n) (can be optimized to O(1))
        public int minSwaps(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            int mismatch = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '[') {
                    stack.offerFirst(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pollFirst();
                    } else {
                        mismatch++;
                    }
                }
            }
            return (mismatch + 1) / 2;
        }
    }
}

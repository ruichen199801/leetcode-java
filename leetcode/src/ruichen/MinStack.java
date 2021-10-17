package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    // #155 https://leetcode.com/problems/min-stack/
    // Stack, Design
    // TC = O(1) (for all operations), SC = O(n)

    class MinStack1 {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack1() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.offerFirst(x);
            if (minStack.isEmpty() || x <= minStack.peekFirst()) { // <= instead of <
                minStack.offerFirst(x);
            }
        }

        public void pop() {
            int res = stack.pollFirst();
            if (res == minStack.peekFirst()) {
                minStack.pollFirst();
            }
        }

        public int top() {
            return stack.peekFirst();
        }

        public int getMin() {
            return minStack.peekFirst();
        }
    }

    class MinStack2 {

        // Optimization: store <min, count> pairs to avoid same number being pushed repeatedly onto minStack

        private Deque<Integer> stack;
        private Deque<int[]> minStack;

        public MinStack2() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.offerFirst(val);
            if (minStack.isEmpty() || minStack.peekFirst()[0] > val) {
                minStack.offerFirst(new int[]{val, 1});
            } else if (minStack.peekFirst()[0] == val) { // else if: mutual exclusive
                minStack.peekFirst()[1]++;
            }
        }

        public void pop() {
            int res = stack.pollFirst();
            if (res == minStack.peekFirst()[0]) {
                minStack.peekFirst()[1]--;
            }
            if (minStack.peekFirst()[1] == 0) {
                minStack.pollFirst();
            }
        }

        public int top() {
            return stack.peekFirst();
        }

        public int getMin() {
            return minStack.peekFirst()[0];
        }
    }


}



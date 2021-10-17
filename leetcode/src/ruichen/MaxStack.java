package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {

    // #716 https://leetcode.com/problems/max-stack/
    // Stack, Design
    // TC = O(n) for popMax(), O(1) for all other operations; SC = O(n)

    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerFirst(x);
        if (maxStack.isEmpty() || maxStack.peekFirst() <= x) {
            maxStack.offerFirst(x);
        }
    }

    public int pop() {
        int ret = stack.pollFirst();
        if (ret == maxStack.peekFirst()) {
            maxStack.pollFirst();
        }
        return ret;
    }

    public int top() {
        return stack.peekFirst();
    }

    public int peekMax() {
        return maxStack.peekFirst();
    }

    // popMax() is tricky: call push 5 4 3 2 1, then popMax 5
    // call push(int x) API inside popMax() to update maxStack with new max after removing curMax
    public int popMax() {
        int curMax = maxStack.pollFirst(); // remove curMax from maxStack, and store it using a variable
        // reverse 2 times with stack: same order
        Deque<Integer> buffer = new ArrayDeque<>();
        while (stack.peekFirst() != curMax) {
            buffer.offerFirst(stack.pollFirst());
        }
        stack.pollFirst(); // remove curMax from stack
        while (!buffer.isEmpty()) { // refill stack and maxStack
            push(buffer.pollFirst());
        }
        return curMax;
    }

}

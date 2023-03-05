package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    /*
    Case 1: If the token is an operator (+, -, *, /), we pop the top two values from the stack,
    perform the operation, and push the result back onto the stack;
    Case 2: If the token is a number, we parse it as an integer and push it onto the stack.
    */

    // TC = O(n), SC = O(n)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (String token : tokens) {
                if (token.equals("+")) {
                    // The first popped out of the stack is the second operand
                    int b = stack.pollFirst();
                    int a = stack.pollFirst();
                    stack.offerFirst(a + b);
                } else if (token.equals("-")) {
                    int b = stack.pollFirst();
                    int a = stack.pollFirst();
                    stack.offerFirst(a - b);
                } else if (token.equals("*")) {
                    int b = stack.pollFirst();
                    int a = stack.pollFirst();
                    stack.offerFirst(a * b);
                } else if (token.equals("/")) {
                    int b = stack.pollFirst();
                    int a = stack.pollFirst();
                    stack.offerFirst(a / b);
                } else {
                    stack.offerFirst(Integer.parseInt(token));
                }
            }
            // At the end, the result is the only value left on the stack, so we pop it and return it.
            return stack.pollFirst();
        }
    }
}

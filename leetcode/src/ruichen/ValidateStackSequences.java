package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {

    // #946 https://leetcode.com/problems/validate-stack-sequences/
    // Stack
    // TC = O(n), SC = O(n)

    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {

            // pushed = [1,2,3,4,5]
            //           i
            // popped = [4,5,3,2,1]
            //           j
            // stack [

            Deque<Integer> stack = new ArrayDeque<>();
            int n = pushed.length, i = 0;
            for (int num : pushed) {
                // we keep pushing until the top element in the stack equals popped
                stack.offerFirst(num);
                while (!stack.isEmpty() && stack.peek() == popped[i]) {
                    stack.pollFirst();
                    i++;
                }
            }
            return i == n; // # of pushes = # of pops
            // since popped.length == pushed.length, return i == popped.length is also correct
        }
    }

}

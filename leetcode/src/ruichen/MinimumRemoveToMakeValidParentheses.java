package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class MinimumRemoveToMakeValidParentheses {
    // TC = O(n), SC = O(n)
    class Solution {
        public String minRemoveToMakeValid(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            Set<Integer> remove = new HashSet<>(); // indices to remove (((

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.offerFirst(i);
                } else if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pollFirst();
                    } else {
                        remove.add(i);
                    }
                }
            }

            while (!stack.isEmpty()) {
                remove.add(stack.pollFirst());
            }

            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!remove.contains(i)) {
                    res.append(s.charAt(i));
                }
            }

            return res.toString();
        }
    }
}

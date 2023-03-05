package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    // TC = O(n), SC = O(n)
    boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.offerFirst(c);
            } else if (!stack.isEmpty() && c == ')' && stack.peekFirst() == '(') {
                stack.pollFirst();
            } else if (!stack.isEmpty() && c == ']' && stack.peekFirst() == '[') {
                stack.pollFirst();
            } else if (!stack.isEmpty() && c == '}' && stack.peekFirst() == '{') {
                stack.pollFirst();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([{}])")); // true
        System.out.println(vp.isValid("[")); // false
        System.out.println(vp.isValid("))")); // false
        System.out.println(vp.isValid("([[)")); // false
    }
}

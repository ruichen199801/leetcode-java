package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    // case 1: positive number
    // case 1.1: all positive numbers: no collision, push()
    // case 1.2: [negative, positive]: no collision, push()

    // case 2: negative number
    // case 2.1: all negative numbers: no collision, push()
    // case 2.2: [positive, negative]
    // case 2.3.1: positive < negative: collision, pop() then push()
    // case 2.3.2: positive = negative: collision, pop() (canceled out)
    // case 2.3.3: positive > negative: collision, do nothing

    // TC = O(n), SC = O(n)
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int asteroid : asteroids) {
                if (asteroid > 0) {
                    stack.offerFirst(asteroid);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                        stack.pollFirst();
                    }
                    // why the while loop ends? -> terminate condition 1 or 2
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.offerFirst(asteroid);
                    } else if (stack.peek() == -asteroid) {  // terminate condition 3
                        stack.pollFirst();
                    }
                }
            }
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pollFirst();
            }
            return result;
        }
    }
}

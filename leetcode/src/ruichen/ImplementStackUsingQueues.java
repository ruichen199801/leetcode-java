package ruichen;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {
    /*
       push(): TC = O(n), SC = O(1)
       pop(), top(), empty(): TC = O(1), SC = O(1)
       MyStack: SC = O(n)
     */
    class MyStack {
        Queue<Integer> q;

        public MyStack() {
            q = new ArrayDeque<>();
        }

        // use rotation to ensure that the newly added element becomes the top of the stack
        public void push(int x) {
            q.offer(x);
            int size = q.size();
            for (int i = 1; i < size; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}

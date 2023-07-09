package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {
    /*
    Stack 1: take input  [  <- 1 2 3
    Stack 2: output      [  ->  a3 2 1
    shuffle once (stack 1 -> stack 2): reverse order
    queue.add(x): stack1.add(x)
    queue.pop():  case 1: if stack2.size() > 0, stack2.pop()
                  case 2: elif stack2 is empty, shuffle all elements from s1 to s2,
                          then stack2.pop()

    poll(), peek(): TC: amortized = O(1), worst case O(n)  SC: O(1)
    offer(): TC = O(1)  SC = O(1)
    size(), isEmpty(): TC = O(1)  SC = O(1)
    MyQueue: SC = O(n)
     */
    class MyQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.offerFirst(x);
        }

        public int pop() {
            shuffle();
            return stack2.pollFirst();
        }

        public int peek() {
            shuffle();
            return stack2.peekFirst();
        }

        public boolean empty() {
            return stack1.size() == 0 && stack2.size() == 0;
        }

        private void shuffle() {
            if (stack2.size() == 0) {
                while (stack1.size() != 0) {
                    stack2.offerFirst(stack1.pollFirst());
                }
            }
        }
    }
}

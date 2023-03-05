package ruichen;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInStringII {
    // Use a stack to store the number of times each element appears (not the element itself!)
    // case 1: if stack is empty or arr[slow] != arr[slow - 1]: stack.push(1)
    // case 2: if arr[slow] == arr[slow - 1]
    //    2.1: if stack.peek() < k: stack.peek() + 1
    //    2.2: if stack.peek() == k: slow = slow - k, stack.pop()
    // slow pointer updates (i++) and points to the next element after each iteration

    // TC = O(n), SC = O(n)
    class Solution {
        public String removeDuplicates(String s, int k) {
            Deque<Integer> counts = new ArrayDeque<>();
            char[] arr = s.toCharArray();
            int i = 0;
            for (int j = 0; j < arr.length; j++, i++) { // i++
                arr[i] = arr[j];
                if (i == 0 || arr[i] != arr[i - 1]) {
                    counts.offerFirst(1);
                } else {
                    int count = counts.pollFirst() + 1;
                    if (count == k) {
                        i -= k;
                    } else {
                        counts.offerFirst(count);
                    }
                }
            }
            return new String(arr, 0, i);
        }
    }
}

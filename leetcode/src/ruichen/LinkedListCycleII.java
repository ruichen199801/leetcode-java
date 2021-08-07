package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {

        // #142 https://leetcode.com/problems/linked-list-cycle-ii/
        // Linked List, Hash Table
        // TC = O(n), SC = O(n)

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            Set<ListNode> visited = new HashSet<>();
            ListNode curr = head;
            while (curr != null) {
                if (visited.contains(curr)) {
                    return curr;
                }
                visited.add(curr);
                curr = curr.next;
            }
            return null;
        }
    }
}

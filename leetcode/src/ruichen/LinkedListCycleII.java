package ruichen;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    // #142 https://leetcode.com/problems/linked-list-cycle-ii/
    // Linked List, Hash Table, Two Pointers

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution1 {

        // Hash Table: TC = O(n), SC = O(n)

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

    public class Solution2 {

        // Floyd's Cycle-Finding Algorithm： TC = O(n), SC = O(1)
        // Step 1: Find intersection where slow and fast pointer meet
        // Step 2: Have two pointers starting at head and intersection, traverse at the same speed

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode intersect = getIntersect(head);
            // no cycle
            if (intersect == null) {
                return null;
            }
            // has a cycle (won't have NPE issue)
            ListNode p1 = head, p2 = intersect;
            while (p1 != p2) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }

        private ListNode getIntersect(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return slow;
                }
            }
            return null;
        }
    }
}

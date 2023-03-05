package ruichen;

import ruichen.common.ListNode;

public class ReverseLinkedList {
    class Solution1 {
        // Iterative: TC = O(n), SC = O(1)
        public ListNode reverseList(ListNode head) {
            ListNode prev = null, curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    class Solution2 {
        // Recursive: TC = O(n), SC = O(n)
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}

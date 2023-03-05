package ruichen;

import ruichen.common.ListNode;

public class MiddleOfTheLinkedList {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}

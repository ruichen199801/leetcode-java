package ruichen;

import ruichen.common.ListNode;

public class RemoveLinkedListElements {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy, curr = head;
            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
            return dummy.next;
        }
    }
}


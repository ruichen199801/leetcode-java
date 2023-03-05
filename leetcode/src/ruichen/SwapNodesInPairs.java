package ruichen;

import ruichen.common.ListNode;

public class SwapNodesInPairs {
    // See #25
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                ListNode start = cur.next, end = cur.next.next;
                ListNode next = end.next;
                end.next = null;
                cur.next = reverse(start);
                start.next = next;
                cur = start;
            }
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode cur = head, prev = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}

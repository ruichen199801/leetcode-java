package ruichen;

import ruichen.common.ListNode;

public class ReverseNodesInEvenLengthGroups {
    // See #25
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            int k = 1;
            int nodesLeft = len(head);
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null) {
                k = Math.min(nodesLeft, k);
                if (k % 2 == 1) {
                    for (int i = 0; i < k; i++) {
                        cur = cur.next;
                    }
                } else {
                    ListNode start = cur.next, end = cur;
                    for (int i = 0; i < k && end.next != null; i++) {
                        end = end.next;
                    }
                    ListNode next = end.next;
                    end.next = null;
                    cur.next = reverse(start);
                    start.next = next;
                    cur = start;
                }
                nodesLeft -= k;
                k++;
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

        private int len(ListNode head) {
            int len = 1;
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
                len++;
            }
            return len;
        }
    }
}

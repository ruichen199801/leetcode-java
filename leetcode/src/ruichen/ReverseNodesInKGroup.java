package ruichen;

import ruichen.common.ListNode;

public class ReverseNodesInKGroup {
    //          1 -> 2 -> 3 -> 4 -> 5    k = 2
    // dummy  head
    //  cur
    //  end   start
    // end moves k times to 2, so we need to put end before start

    // reverse: 2 -> 1, 3 -> 4 -> 5
    // TODO1: dummy -> 2
    // TODO2: 1 -> 3
    // TODO3: move cur to 1

    //          2 -> 1 -> 3 -> 4 -> 5    k = 2
    // dummy  head
    //              cur
    //              end start

    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null) {
                ListNode start = cur.next, end = cur;
                for (int i = 0; i < k; i++) {
                    end = end.next;
                    // reach the end before moving k times
                    if (end == null) {
                        return dummy.next;
                    }
                }
                ListNode next = end.next;
                end.next = null; // cut before reverse
                cur.next = reverse(start); // TODO1
                start.next = next; // TODO2
                cur = start; // TODO3
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

package ruichen;

import ruichen.common.ListNode;

public class PartitionList {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode left = new ListNode(0);
            ListNode right = new ListNode(0);
            ListNode cur = head, l = left, r = right;
            // merge
            while (cur != null) {
                if (cur.val < x) {
                    l.next = cur;
                    l = l.next;
                } else {
                    r.next = cur;
                    r = r.next;
                }
                cur = cur.next;
            }
            // concatenate
            l.next = right.next;
            r.next = null;
            return left.next;
        }
    }
}

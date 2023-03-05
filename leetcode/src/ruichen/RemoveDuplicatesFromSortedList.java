package ruichen;

import ruichen.common.ListNode;

public class RemoveDuplicatesFromSortedList {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next; // change reference operation, skip the next node
                } else {
                    cur = cur.next; // do nothing, move on to process next node
                }
            }
            return head;
        }
    }
}

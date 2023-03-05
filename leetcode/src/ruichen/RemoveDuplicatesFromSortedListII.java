package ruichen;

import ruichen.common.ListNode;

public class RemoveDuplicatesFromSortedListII {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    ListNode temp = cur.next;
                    while (temp.next != null && temp.val == temp.next.val) {
                        temp = temp.next;
                    }
                    cur.next = temp.next; // skip all duplicate nodes
                } else {
                    cur = cur.next; // change nothing
                }
            }
            return dummy.next;
        }
    }
}

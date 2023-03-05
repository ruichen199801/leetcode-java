package ruichen;

import ruichen.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    // one pass
    // fast runs ahead of slow by n
    // when fast reaches end, slow stops right before the note to be deleted
    //   1->2->3->4->5, n = 2
    // s f

    // maintain a dummy node to play around NPE (1 <= sz <= 30, 1 <= n <= sz, sz = size of linked list)
    // 1 -> null, n = 1
    // dummmy -> 1 -> null
    //   s       f
    //   s.next = s.next.next, which is null

    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy, fast = head;
            for (int i = 0; i < n - 1; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            //   1->2->3->4->5, n = 2
            //         s     f
            // delete operation
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}

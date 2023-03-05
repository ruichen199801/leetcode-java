package ruichen;

import ruichen.common.ListNode;

public class DeleteNNodesAfterMNodesOfALinkedList {
    class Solution1 {
        // Use dummy node: TC = O(n), SC = O(1)
        public ListNode deleteNodes(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (head != null) {
                for (int i = 0; i < m && head != null; i++) {
                    cur.next = head;
                    cur = cur.next;
                    head = head.next;
                }
                for (int i = 0; i < n && head != null; i++) {
                    head = head.next;
                }
            }
            cur.next = null; // set tailing copies to null
            return dummy.next;
        }
    }

    class Solution2 {
        // Without dummy node: TC = O(n), SC = O(1)
        public ListNode deleteNodes(ListNode head, int m, int n) {
            // slow: mark result, fast: traverse and process
            ListNode slow = head, fast = head;
            while (fast != null) {
                int mCount = m, nCount = n;
                while (fast != null && mCount > 0) {
                    // do nothing
                    slow = fast; // one step behind fast
                    fast = fast.next;
                    mCount--;
                }
                while (fast != null && nCount > 0) {
                    // stop slow, only move fast
                    fast = fast.next;
                    nCount--;
                }
                // delete
                slow.next = fast;
            }
            return head;
        }
    }
}

package ruichen;

public class DeleteNNodesAfterMNodesOfALinkedList {

    // #1474 https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
    // Linked List
    // TC = O(n), SC = O(1)

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution1 {
        // dummy node
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
        // without dummy node
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

package ruichen;

public class RotateList {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {

        // #61 https://leetcode.com/problems/rotate-list/
        // Linked List, Two Pointers
        // TC = O(n), SC = O(1)

        public ListNode rotateRight(ListNode head, int k) {
            // 1 -> 2 -> 3 -> 4 (newHead) -> 5
            // |_____________________________|
            // newHead: n - k % n
            if (head == null || head.next == null) {
                return head;
            }
            ListNode oldTail = head;
            int n = 1;
            while (oldTail.next != null) {
                oldTail = oldTail.next;
                n++;
            }
            oldTail.next = head;

            ListNode newTail = head;
            for (int i = 0; i < n - k % n - 1; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;
            newTail.next = null;
            return newHead;
        }
    }
}

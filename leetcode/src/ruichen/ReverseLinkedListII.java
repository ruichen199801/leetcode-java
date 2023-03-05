package ruichen;

import ruichen.common.ListNode;

public class ReverseLinkedListII {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // | xxxx left yyyy right zzzz|
            ListNode result = new ListNode(0);
            ListNode res = result, curr = head;
            // first part, copy
            for (int i = left - 1; i > 0; i--) {
                res.next = curr;
                res = res.next;
                curr = curr.next;
            }
            // second part, reverse
            ListNode first = curr;
            for (int j = right - left; j > 0; j--) { // alternatively, this for-loop can wrap the reverseList part
                curr = curr.next;
            }
            ListNode last = curr.next;
            curr.next = null;
            res.next = reverseList(first);
            // third part, copy
            while (res.next != null) {
                res = res.next;
            }
            res.next = last;
            return result.next;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }
}

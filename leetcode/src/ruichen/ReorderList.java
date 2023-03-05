package ruichen;

import ruichen.common.ListNode;

public class ReorderList {
    // TC = O(n), SC = O(1)
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            // partition into two halves
            ListNode mid = middleNode(head);
            ListNode two = mid.next;
            mid.next = null;
            // reverse right half, then merge
            merge(head, reverse(two));
        }

        private ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

        private void merge(ListNode one, ListNode two) {
            ListNode cur = new ListNode(0);
            while (one != null && two != null) {
                cur.next = one;
                one = one.next;
                cur.next.next = two;
                two = two.next;
                cur = cur.next.next;
            }
            if (one != null) {
                cur.next = one;
            } else {
                cur.next = two;
            }
        }
    }
}

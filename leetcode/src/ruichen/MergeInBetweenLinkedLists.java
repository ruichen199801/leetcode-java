package ruichen;

public class MergeInBetweenLinkedLists {

    // #1669 https://leetcode.com/problems/merge-in-between-linked-lists/
    // Linked List
    // TC = O(n), SC = O(1)

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            // 3 <= list1.length <= 10^4
            // 1 <= a <= b < list1.length - 1
            // 1 <= list2.length <= 10^4
            ListNode cur1 = list1, cur2 = list2;
            for (int i = 0; i < a - 1; i++) {
                cur1 = cur1.next;
            }
            ListNode insertHead = cur1;
            for (int i = 0; i < b - a + 2; i++) {
                cur1 = cur1.next;
            }
            ListNode insertTail = cur1;
            insertHead.next = cur2;
            while (cur2.next != null) {
                cur2 = cur2.next;
            }
            cur2.next = insertTail;
            return list1;
        }
    }
}

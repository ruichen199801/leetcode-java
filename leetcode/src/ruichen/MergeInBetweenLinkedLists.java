package ruichen;

import ruichen.common.ListNode;

public class MergeInBetweenLinkedLists {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
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

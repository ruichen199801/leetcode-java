package ruichen;

import ruichen.common.ListNode;

public class OddEvenLinkedList {
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode oddHead = new ListNode(0);
            ListNode evenHead = new ListNode(0);
            ListNode cur = head, oddCur = oddHead, evenCur = evenHead;
            int index = 1;

            while (cur != null) {
                if (index % 2 == 1) {
                    oddCur.next = new ListNode(cur.val);
                    oddCur = oddCur.next;
                } else {
                    evenCur.next = new ListNode(cur.val);
                    evenCur = evenCur.next;
                }
                cur = cur.next;
                index++;
            }

            ListNode res = new ListNode(0);
            ListNode resCur = res;
            resCur.next = oddHead.next;
            oddCur.next = evenHead.next;

            return res.next;
        }
    }
}

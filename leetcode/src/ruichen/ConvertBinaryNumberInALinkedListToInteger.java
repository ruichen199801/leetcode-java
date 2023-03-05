package ruichen;

import ruichen.common.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    // TC = O(n), SC = O(1)
    class Solution {
        public int getDecimalValue(ListNode head) {
            if (head == null) {
                return 0;
            }
            int res = 0;
            while (head != null) {
                res = res * 2 + head.val;
                head = head.next;
            }
            return res;
        }
    }
}

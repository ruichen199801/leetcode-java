package ruichen;

public class ConvertBinaryNumberInALinkedListToInteger {

    // #1290 https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
    // Linked List, Math
    // TC = O(n), SC = O(1)

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

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

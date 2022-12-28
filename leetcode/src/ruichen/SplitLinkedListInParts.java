package ruichen;

public class SplitLinkedListInParts {

    // #725 https://leetcode.com/problems/split-linked-list-in-parts/
    // Linked List
    // TC = O(n + k) (if k >> n, answer will be a list of empty listnodes)
    // SC = O(k) (for storing answer)

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            // 12 / 3 = 4， 12 % 3 = 0 -> 3, 3, 3, 3
            // 13 / 3 = 4， 13 % 3 = 1 -> 4, 3, 3, 3 (first 13 % 3 = 1 part have one more item)
            // 14 / 3 = 4， 14 % 3 = 2 -> 4, 4, 3, 3 (first 14 % 3 = 2 parts have one more item)
            ListNode[] res = new ListNode[k];
            ListNode prev = head, cur = head; // prev: head, cur: tail
            int len = computeLen(head); // length of the linked list
            int size = len / k, extra = len % k; // size for each part
            for (int i = 0; i < k && cur != null; i++) {
                for (int j = 0; j < size + (i < extra ? 1 : 0) - 1; j++) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                res[i] = prev;
                cur = next;
                prev = next;
            }
            return res;
        }

        private int computeLen(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}

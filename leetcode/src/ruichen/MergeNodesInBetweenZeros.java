package ruichen;

public class MergeNodesInBetweenZeros {

    // #2181 https://leetcode.com/problems/merge-nodes-in-between-zeros/
    // Linked list
    // TC = O(n), SC = O(1)

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = new ListNode(0);
            ListNode cur = head, resCur = dummy;
            int sum = 0;
            while (cur != null) {
                if (cur.val == 0) {
                    if (sum != 0) {
                        resCur.next = new ListNode(sum);
                        resCur = resCur.next;
                        sum = 0;
                    }
                } else {
                    sum += cur.val;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}

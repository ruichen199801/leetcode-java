package ruichen;

import ruichen.common.ListNode;

public class SwappingNodesInALinkedList {
    // One pass: find position of two nodes using slow and fast pointer without computing length of linked list
    // TC = O(n), SC = O(1)
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            // 1 <= k <= n
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast = head;
            for (int i = 1; i < k; i++) {
                fast = fast.next;
            }
            ListNode node1 = fast; // find node 1
            ListNode slow = head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            ListNode node2 = slow; // find node 2
            swap(node1, node2);
            return head;
        }

        private void swap(ListNode node1, ListNode node2) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }
}

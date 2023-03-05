package ruichen;

import ruichen.common.ListNode;

public class DeleteNodeInLinkedList {
    // replace with the val of next node, then change reference
    // 1 -> 2 -> 3 -> 4, delete 2
    // step 1: change 2 to 3
    // step 2: point the new 3 to 4, skip the old 3
    // not a tail node assumption: avoid NPE case

    // TC = O(1), SC = O(1)
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}

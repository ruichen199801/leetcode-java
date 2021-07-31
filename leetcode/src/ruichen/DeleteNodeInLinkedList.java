package ruichen;

public class DeleteNodeInLinkedList {
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #237 https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
	    // Linked List
	    // TC = O(1), SC = O(1)

	    public void deleteNode(ListNode node) {
	        // replace with the val of next node, then change reference
	        // 1 -> 2 -> 3 -> 4, delete 2
	        // step 1: change 2 to 3
	        // step 2: point the new 3 to 4, skip the old 3
	        // not a tail node assumption: avoid NPE case
	        node.val = node.next.val;
	        node.next = node.next.next;
	    }
	}

}

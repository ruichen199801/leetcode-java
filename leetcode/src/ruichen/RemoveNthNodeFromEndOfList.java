package ruichen;

public class RemoveNthNodeFromEndOfList {
	
	class ListNode {
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #19 https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	    // Linked List, Two Pointers
	    // TC = O(n), SC = O(1)

	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        // one pass
	        // fast runs ahead of slow by n
	        // when fast reaches end, slow stops right before the note to be deleted
	        //   1->2->3->4->5, n = 2
	        // s f
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode slow = dummy, fast = head;
	        for (int i = 0; i < n - 1; i++) {
	            fast = fast.next;
	        }   
	        while (fast.next != null) {
	            fast = fast.next;
	            slow = slow.next;
	        }
	        //   1->2->3->4->5, n = 2
	        //         s     f
	        // delete operation
	        slow.next = slow.next.next;
	        return dummy.next;
	    }
	}

}

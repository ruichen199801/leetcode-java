package ruichen;

public class RemoveLinkedListElements {
	
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #203 https://leetcode-cn.com/problems/remove-linked-list-elements/
	    // Linked List
	    // TC = O(n), SC = O(1)

	    public ListNode removeElements(ListNode head, int val) {
	        if (head == null) {
	            return null;
	        }
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode prev = dummy, curr = head;
	        while (curr != null) {
	            if (curr.val == val) {
	                prev.next = curr.next;
	            } else {
	                prev = curr;
	            }
	            curr = curr.next;
	        }
	        return dummy.next;
	    }
	}

}


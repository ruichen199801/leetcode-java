package ruichen;

public class AddTwoNumbers {
	
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}
	
	class Solution {

	    // #2 https://leetcode.com/problems/add-two-numbers/
	    // Math, Linked List
	    // TC = O(max(m, n), SC = O(max(m, n)), m, n = # of nodes in l1 and l2

	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode dummy = new ListNode(0);
	        ListNode cur = dummy;
	        int val = 0;
	        while (l1 != null || l2 != null || val != 0) {
	            if (l1 != null) {
	                val += l1.val;
	                l1 = l1.next;
	            }
	            if (l2 != null) {
	                val += l2.val;
	                l2 = l2.next;
	            }
	            cur.next = new ListNode(val % 10);
	            val /= 10;
	            cur = cur.next;
	        }
	        return dummy.next;
	    }
	}

}

//
//
//
//
//

